package br.com.tcc.config;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.SerializationUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.AttributeConverter;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.util.Base64;

@Configuration
public class CriptografiaAesConfig implements AttributeConverter<Double, String> {

    @Value("${aes.encryption.key}")
    private String chaveCriptografia;
    private final String cifraCriptografia = "AES";

    private Key chave;
    private Cipher cifra;

    private Key getChave() {
        if(chave == null) {
            chave = new SecretKeySpec(chaveCriptografia.getBytes(), cifraCriptografia);
        }
        return chave;
    }

    private Cipher getCifra() throws GeneralSecurityException {
        if(cifra == null) {
            cifra = Cipher.getInstance(cifraCriptografia);
        }
        return cifra;
    }

    private void initCifra(int modoCriptografia) throws GeneralSecurityException {
        getCifra().init(modoCriptografia, getChave());
    }

    // criptografar
    @SneakyThrows
    @Override
    public String convertToDatabaseColumn(Double valor) {
        if(valor == null) {
            return null;
        }
        initCifra(Cipher.ENCRYPT_MODE);
        byte[] bytes = SerializationUtils.serialize(valor);
        return Base64.getEncoder().encodeToString(getCifra().doFinal(bytes));
    }

    // descriptografar
    @SneakyThrows
    @Override
    public Double convertToEntityAttribute(String valorCripto) {
        if(valorCripto == null) {
            return null;
        }
        initCifra(Cipher.DECRYPT_MODE);
        byte[] bytes = getCifra().doFinal(Base64.getDecoder().decode(valorCripto));
        return (Double) SerializationUtils.deserialize(bytes);
    }
}
