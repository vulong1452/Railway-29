import java.util.Iterator;

public class VnPhone extends Phone {

	@Override
	void insertContact(String name, String phone) {
		Contact contact = new Contact(phone, name);
		super.contacts.add(contact);

	}

	@Override
	void removeContact(String name) {
		contacts.removeIf(contacts -> contacts.getName().equals(name));

	}

	@Override
	void updateContact(String name, String newPhone) {
		for (int i = 0; i < contacts.size(); i++) {
			if (contacts.get(i).getName().equals(name)) {
				contacts.set(i, new Contact(newPhone, name));
				break;
			}
		}
	}

	@Override
	void searchContact(String name) {
		for (Contact contact : contacts) {
			if(contact.getName().equals(name)) {
				System.out.println(contact);
				break;
			}
		}
	}

	void printContact() {
		for (int i = 0; i < contacts.size(); i++) {
			System.out.println(i + " " + contacts.get(i).toString());
		}

	}

}
