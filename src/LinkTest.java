
public class LinkTest {
 public static void main(String[] args) {
	  Link root =new Link(5);
	  Link root1 =new Link(4);
	  Link root2 =new Link(4);
	  Link root3 =new Link(1);
	  root.add(root, root1);
      root.add(root1, root2);
      root.add(root2, root3);
      System.out.println("����:"+root.toString());
      root.Search(root, 4);
      System.out.println("����:"+root.toString());
      root.Delete(root, root3);
      System.out.println("ɾ��:"+root.toString());
      root.Update(root, 4, 2);
	  System.out.println("�޸�:"+root.toString());
}
}
