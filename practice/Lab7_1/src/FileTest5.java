import java.io.*;
import java.util.Vector;

class Book implements Serializable{
	String title;
	String author;
	int price;
	 
	public Book(String title, String author, int price) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", price=" + price + "]";
	}	
}
public class FileTest5 {
	public static void main(String[] args) throws Exception {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("obj.data"));
		//여러개를 저장할 거라면.
		Vector<Book> v = new Vector<>();
		for (int i =0; i<10; i++) {
			v.add(new Book("책"+i, "저자"+i, 1000*(i+1)));
		}
		
		oos.writeObject(v);
		int arr[] = new int[10];
		//초기화
		for(int i=0; i<arr.length; i++) {
			arr[i] = i*10;
		}
		oos.writeObject(arr);
		oos.close();
		System.out.println("저장완료");
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("obj.data"));
		Vector <Book> b = (Vector<Book>)ois.readObject();
		for (int i=0; i<b.size();i++) {
			System.out.println(b.get(i));	
		}
		int a[]= (int[])ois.readObject();
		for(int i=0; i<a.length; i++)
			System.out.println(a[i]);
		ois.close();

	}

}
