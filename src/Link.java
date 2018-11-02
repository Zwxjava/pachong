
public class Link<T> {
   private T date;
   private Link<T> nextnode;
   public Link() {
	   
   }
   public Link(T date) {
	   this.date = date;
   }
   public Link(T date,Link<T> nextnode) {
	   this.date = date;
	   this.nextnode =nextnode;
   }
	public T getDate() {
		return date;
	}
	public void setDate(T date) {
		this.date = date;
	}
	public Link<T> getNextnode() {
		return nextnode;
	}
	public void setNextnode(Link<T> nextnode) {
		this.nextnode = nextnode;
	}
     
	@Override
	public String toString() {
		return "Link [date=" + date + ", nextnode=" + nextnode + "]";
	}
	int i =1;
	public void add(Link<T> node,Link<T> nextNode) {
		if (node!=null) {
			node.nextnode = nextNode;
		}else {
			System.out.println("�ڵ�Ϊ��");
		}
	}
	
	public void Search(Link<T> node,T date) {
		if (node ==null) {
			System.out.println("��ͷ��");
		}else {
		if (node.date == date) {
			System.out.println("���ǵ�"+i+"���");
			i++;
			Search(node.nextnode, date);
		}else {
			i++;
			Search(node.nextnode, date);
			
		}		
		}
	}
	
	public void Update(Link<T> node,T date,T ud) {
		if (node ==null) {
			System.out.println("��ͷ��");
		}else {
		if (node.date == date) {
			node.date =ud;
			Update(node.nextnode, date, ud);
			System.out.println("�޸����");
		}else {
			Update(node.nextnode, date, ud);
		}
		}
	}
	
	public void Delete(Link<T> node,Link<T> nodetwo) {
		if (node ==null) {
			System.out.println("��ͷ��");
		}else {
		if (node.nextnode == nodetwo ) {
			node.nextnode =nodetwo.nextnode;
			nodetwo.nextnode = null;			
			System.out.println("ɾ�����");		
		}else {
			Delete(node.nextnode,nodetwo);
		}
		
	}
	}
}
