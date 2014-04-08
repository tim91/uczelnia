package network.gsm.patterns;

public interface Plan {

	/**
	 * Metoda jest odpowiedzialna za zwrocenie kosztu zwiazanego z wyslanie sms'a
	 * @return koszt sms'a
	 */
	public float sendSms();
	
	/**
	 * Metoda jest odpowiedzialna za zwrocenie kosztu rozmowy wg danego planu
	 * @return koszt rozmowy
	 */
	public float call();
	
	
	/**
	 * Metoda jest odpowiedzialna za zwrocenie kosztu pobrania danych
	 * @return
	 */
	public float downloadData();
	
	
	/**
	 * Metoda zwraca kopie obiektu, ktory implementuje ten interfejs
	 * @return Instancje obiektu
	 * @throws CloneNotSupportedException
	 */
	public Object clone() throws CloneNotSupportedException;
}
