package Persistence;

import Dominion.Author;
import Dominion.Reviewer;

public class NoPersistence {

	/**
	 * @param args
	 * @throws Exception
	 * @Reviewer Buggin' & Debuggin' 
	 */
	public static void main(String[] args) throws Exception {
		
		//Reviewer a= new Reviewer("Titul", "2012-09-12", "1@autor.com","tachinda", "send", 10);
		
		CrudDAO<Author> a = new AuthorDAO();
		
		//leyendo
//		Author autor= new Author();
//		autor.setEmail("2@autor.com");
//		autor = a.read(autor);
//		System.out.println(autor.toString());
		
		
//		// creando.
//		Author autor = new Author("148@autor.com", "edupichas", "garcia", "pillin", "san clemente", "2012-12-12", 10);
//		a.create(autor);
//		System.out.println(autor.toString());
		
		//actualizando
		Author autor= new Author();
		autor.setCity("pedroñeras");
		autor.setName("pepito");
		a.update(autor);
		
		//borrando
//		Reviewer articulo= new Reviewer("otro");
//		c.delete(articulo);
		
		//leyendo todos
//		Reviewer articulo= new Reviewer();
//		articulo.setMail_notified("7@autor.com");
//		LinkedList<Reviewer> l=c.readAll(articulo);
//		System.out.println(l.toString());
		
			
	}
}