
public class Main {
	public static void main(String[] args) {
		VnPhone vnPhone = new VnPhone();
		
		vnPhone.insertContact("abc", "0123456789");
		vnPhone.insertContact("acb", "0123466789");
		vnPhone.insertContact("acd", "0123457789");
		
		vnPhone.printContact();
		System.out.println("------Search--------");
		vnPhone.searchContact("abc");
		System.out.println("--------Remove----------");
		vnPhone.removeContact("acd");
		vnPhone.printContact();
		System.out.println("------Update-----");
		vnPhone.updateContact("abc", "0953845093");
		vnPhone.printContact();
	}
}
