package lists;

public class ListaSimples {
	No inicio = null; //pointer to the first item
	int size = 0;

	public void inserirInicio(String info) {  //insert an item on the beggining of the list
		if(isFull()) {
			System.out.println("A lista já está cheia");
		}else {
			No no = new No();
			no.info = info;
			no.next = this.inicio;
			this.inicio = no;
			this.size++;
		}
	}

	public void inserirMeio (String info) {  //insert an item on the second position of the list
		if(isFull()) {
			System.out.println("A lista já está cheia");
		}else {
			No no = new No();
			no.info = info;
			no.next = this.inicio.next;
			this.inicio.next = no;
			this.size++;
		}
	}

	public void inserirFim (String info) { //insert an item on the end of the list
		if(isFull()) {
			System.out.println("A lista já está cheia");
		}else {
			No no = new No();
			no.info = info;
			if(this.inicio==null) {
				this.inicio = no;
				no.next = null;
			}else {
				No local = this.inicio;
				while(local.next != null) {
					local = local.next;
				}
				local.next = no;
				no.next = null;
				this.size++;
			}
		}
	}

	public int removeInfo (String info) {  //remove an item using it's info as parameter
		No local = this.inicio;
		int index = 0;
		for (index = 0; index < this.size; index++) {
			if(local.info.equals(info)) {
				remove(index);
			}
			local = local.next;
		}
		return 0;
	}

	public String remove (int index) {
		if(index < 0 || index >= this.size || this.inicio == null) {
			return null;
		}else if (index == 0) {
			return retirarInicio();
		}else if (index == this.size-1) {
			return retirarFim();
		}
		No local = this.inicio;
		for (int i = 0; i < index-1; i++) {
			local = local.next;
		}
		String info = local.next.info;
		local.next = local.next.next;
		size--;
		return info;
	}

	private String retirarFim () { //remove an item from the end of the list
		No local = this.inicio;
		for (int i = 1; i < this.size-1; i++) {
			local = local.next;
		}
		local.next = null;
		this.size--;
		return null;
	}

	private String retirarInicio() { //remove an item from the beggining of the list
		if(inicio==null) {
			return null;
		}
		String info = this.inicio.info;
		inicio = this.inicio.next;
		this.size--;
		return info;
	}

	public String search(String info) {
		No local = this.inicio;
		int count = 0;
		while (count < this.size) {
			if(local.info.equals(info)){
				return "O nome " + info + " está na lista";
			}
			local = local.next;
			count++;
		}
		return "O nome " + info + " não está na lista";
	}

	public boolean isFull () {
		if(this.size == 7) {
			return true;
		}
		return false;
	}

	public String toString() {
		String str = "(" + this.size + ") " ;
		No local = this.inicio;
		while (local != null) {
			str += local.info + " | " ;
			local = local.next;
		}
		return str;
	}

	public int size() {
		return this.size;
	}
}