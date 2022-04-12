package lists;

public class ListaDupla {
	No first = null; //pointer to the first item
	No last = null; //pointer to the last item
	int length = 0;

	public void insertAtStart (String info) {
		No no = new No();
		no.info = info;
		no.previous = null;
		no.next = this.first;
		if(this.first != null) {
			this.first.previous = no;
		}
		this.first = no;
		if(this.first.next == null) {
			this.last = this.first;
		}
		this.length++;
	}

	public void insertAtEnd (String info) {
		No no = new No();
		no.info = info;
		no.next = null;
		no.previous = this.last;
		if(this.first == null) {
			this.first = no;
			this.last = this.first;
		}else {
			this.last.next = no;
			
		}
		this.last = no;
		this.length++;
	}

	public String remove (int index) {
		if(index < 0 || index >= this.length || this.first == null) {
			return null;
		}else if (index == 0) {
			return removeFromStart();
		}else if (index == this.length-1) {
			return removeFromEnd();
		}
		No local = this.first;
		for (int i = 0; i < index-1; i++) {
			local = local.next;
		}
		String info = local.next.info;
		if(local.next.next != null) {
			local.next.next.previous = local;
		}
		local.next = local.next.next;
		this.length--;
		return info;
	}

	private String removeFromStart () {
		No local = this.first;
		this.first = this.first.next;
		this.first.previous = null;
		this.length--;
		return local.info;
	}

	private String removeFromEnd () {
		No local = this.last;
		this.last = this.last.previous;
		this.last.next = null;
		this.length--;
		return local.info;
	}
	
	public ListaDupla revert (ListaDupla lista) { //reverts the list's order
		No local = this.first;
		ListaDupla l = new ListaDupla();
		No local2;
		while (local != null) {
			local2 = local;
			local2.previous = local.next;
			local2.next = local.previous;
			l.insertAtStart(local.info);
			local = local.next;
			local2 = local2.previous;
		}
		return l;
	}

	public String toString() {
		String str = "(" + this.length + ") " ;
		No local = this.first;
		while (local != null) {
			str += local.info + " | " ;
			local = local.next;
		}
		return str;
	}
}