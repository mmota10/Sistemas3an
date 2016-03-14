package projeto.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;

public class Criptografia {

	private static final String ALGORITMO = "RSA";
	private static final String ARQUIVO_CHAVE_PRIVADA = "D:/workspace/Sol'Systems/chaves/privada.key";
	private static final String ARQUIVO_CHAVE_PUBLICA = "D:/workspace/Sol'Systems/chaves/publica.key";
	
	public Criptografia() {
		
	}
	
	public static String getArquivoChavePrivada() {
		return ARQUIVO_CHAVE_PRIVADA;
	}

	public static String getArquivoChavePublica() {
		return ARQUIVO_CHAVE_PUBLICA;
	}

	public static void gerarChave() {
		try {
				
			KeyPairGenerator geradorChave = KeyPairGenerator.getInstance(ALGORITMO);
			geradorChave.initialize(1024);
			
			KeyPair chave = geradorChave.generateKeyPair();
			
			File chavePrivada = new File(ARQUIVO_CHAVE_PRIVADA);
			File chavePublica = new File(ARQUIVO_CHAVE_PUBLICA);
			
			//Processo de criacao da chave privada
			if (chavePrivada.getParentFile() != null)
				chavePrivada.getParentFile().mkdirs();
			
			chavePrivada.createNewFile();
			
			//Processo de criacao da chave publica
			if (chavePublica.getParentFile() != null) 
				chavePublica.getParentFile().mkdirs();
			
			chavePublica.createNewFile();
			
			//Serializa a chave pública
			ObjectOutputStream chavePublicaSerializada = new ObjectOutputStream(new FileOutputStream(chavePublica));
			chavePublicaSerializada.writeObject(chave.getPublic());
			chavePublicaSerializada.close();
			
			//Serializa a chave privada
			ObjectOutputStream chavePrivadaSerializada = new ObjectOutputStream(new FileOutputStream(chavePrivada));
			chavePrivadaSerializada.writeObject(chave.getPrivate());
			chavePrivadaSerializada.close();
				
		} catch(Exception excecao) {
			excecao.printStackTrace();
		}
	}

	public static boolean verificarChaves() {
		boolean existe = false;
		File chavePrivada = new File(ARQUIVO_CHAVE_PRIVADA);
		File chavePublica = new File(ARQUIVO_CHAVE_PUBLICA);
		
		if(chavePrivada.exists() && chavePublica.exists())
			existe = true;
		
		return existe;
	}

	public byte[] criptografar(String texto, PublicKey chave) {
		byte[] textoCifrado = null;
		
		try {
			
			Cipher cifra = Cipher.getInstance(ALGORITMO);
			
			cifra.init(Cipher.ENCRYPT_MODE, chave);
			
			textoCifrado = cifra.doFinal(texto.getBytes());
			
		} catch(Exception excecao) {
			excecao.printStackTrace();
		}
		
		return textoCifrado;
	}
	
	public String decriptografar(byte[] texto, PrivateKey chave) {
		byte[] textoDecifrado = null;
		
		try {
			
			Cipher cifra = Cipher.getInstance(ALGORITMO);
			
			textoDecifrado = cifra.doFinal(texto);
			
		}catch(Exception excecao) {
			excecao.printStackTrace();
		}
		
		return new String(textoDecifrado);
	}
	
}// fim da classe