
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	library library=new library("dorsa");
//	load(library);
	Scanner in = new Scanner(System.in);
whileloop:	while (true){
        String n =in.nextLine();
switch (n){
    case "add":
        String a=in.nextLine();
        switch (a){
            case "member":
                try {
                    int id=in.nextInt();
                    String firstname=in.next();
                    String provincename=in.next();
                    String townname =in.next();
                    String streetname =in.next();
                    int plaque=in.nextInt();
                    address address= new address(provincename,townname,streetname,plaque);
                    library.addmember(new member(firstname,null,id,address));
                }catch (InputMismatchException e){
                    e.printStackTrace();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {

                }
                break;
            case "book":
                int Id=in.nextInt();
                String name=in.next();
                int writer =in.nextInt();
                writer[] writers=new writer[writer];
                for (int i = 0; i <writer ; i++) {
                    String writerfirstname=in.next();
                    String writerlastname=in.next();
                    writers[i]=new writer(writerfirstname,writerlastname);
                }
                int year=in.nextInt();
                book book=new book(name,Id,year,writers);
                library.addbook(book);
                break;
            case"item":

                 int memberid=in.nextInt();
                 int bookid=in.nextInt();
                 try {
                     library.getborrow(memberid).addborrowbook(library.getbook(bookid));
                 }catch (Exception e)
                 {
                     System.out.println(e.getMessage());

                 }finally {

                 }
                break;

            case"borrow":
                int ID=in.nextInt();
                int memberrid=in.nextInt();
                try {
                    library.addborrowed(new borrow(library.getmember(memberrid),ID,library));
                }catch (Exception e){
                    e.printStackTrace();
                }finally {

                }
                break;
            default:
                break ;
        }
        break ;

    case "remove":
        String b=in.next();
        switch (b){
            case "item":
                try {
                    int memberid=in.nextInt();
                    int bookid=in.nextInt();
                    library.getborrow(memberid).removeborrowbook(library.getbook(bookid));
                }catch (InputMismatchException e){
                    e.printStackTrace();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    break;
                }
        }
        break;
    case "report":
        String c=in.next();
        switch (c){
            case "customers":
                try {
                    for (int i = 0; i < library.getMembers().length; i++) {
                        member MEMBER=library.getMembers()[i];
                        if(MEMBER!=null){
                            System.out.println(MEMBER.getId()+","+MEMBER.getFirstname()+","+"0"+","+ MEMBER.getAddress().toString());
                    }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    break;
                }

            case"borrow":
                 int id=in.nextInt();
                 borrow borrow=library.getborrow(id);
                System.out.print(borrow.getId()+","+borrow.getMember().getId());
                for (int i = 0; i <borrow.getBooks().length ; i++) {
                    book book = borrow.getBooks()[i];
                    if (book != null) {
                        System.out.println(","+book.getId() + "," + book.getName() + "," + book.getYear() + ",");
                        writer[] writers = borrow.getBooks()[i].writers;
                        for (int j = 0; j < writers.length&&writers[j]!=null; j++) {
                            writer Writer = borrow.getBooks()[i].getWriters()[j];
                            if (Writer != null) {
                                System.out.println(Writer.getFirstname() + "," + Writer.getLastname());
                            }
                        }
                    }
                }
                break;
            case"books":
                int tedad=0;
                for (int i = 0; i <library.getNotborrowed().length; i++) {
                    book Book=library.getNotborrowed()[i];
                    if (Book!=null){
                        tedad++;
                    }
                }
                System.out.println(tedad);
                break;
        }
        break;
    case "terminate":
//        try {
//            FileOutputStream file = new FileOutputStream(new File("library.txt"));
//            ObjectOutputStream object = new ObjectOutputStream(file);
//            object.writeObject(library);
//            object.close();
//            file.close();
//            System.out.println("file save successfully");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
            break whileloop;
//        }

}

    }
    }
    public static void load(library library){

        try {
            FileInputStream     fileInputStream = new FileInputStream("library.txt");
            ObjectInputStream objectInputStream =new ObjectInputStream(fileInputStream);
            library = (library) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
class address implements Serializable {
    private String provincname;
    private String townname;
    private String streetname;
    private int plaque;

    public address(String provincname, String townname, String streetname, int plaque) {
        this.provincname = provincname;
        this.townname = townname;
        this.streetname = streetname;
        this.plaque = plaque;
    }

    @Override
    public String toString() {
        return provincname+","+ townname+","+streetname+","+plaque;   }
}
class book extends documents implements Serializable {
    public book(String name, int id, int year, writer[] writers) {
        super(name, id, year, writers);
    }
}
class borrow implements Serializable {
    private member member;
    private int id;
    private int borrowed=0;
    private book[] books=new book[10];
    private library library;

    public borrow(member member, int id, library library) {
        this.member = member;
        this.id = id;
        this.library = library;
    }

    public member getMember() {
        return member;
    }

    public int getId() {
        return id;
    }

    public int getBorrowed() {
        return borrowed;
    }

    public book[] getBooks() {
        return books;
    }
    public void addborrowbook(book book){
        for (int i = 0; i <books.length ; i++) {
            if(books[i]==null){
                books[i]=book;
                borrowed++;
                library.addborrowedbooks(book);
                break;
            }
        }
    } public void removeborrowbook(book book){
        for (int i = 0; i <books.length ; i++) {
            if(books[i]==book){
                books[i]=null;
                break;
            }
            borrowed--;
            library.removeborrowedbooks(book);
        }
    }
}
class documents implements Serializable {
    protected String name;
    protected int id;
    protected int year;
    protected writer[] writers;

    public documents(String name, int id, int year, writer[] writers) {
        this.name = name;
        this.id = id;
        this.year = year;
        this.writers = writers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public writer[] getWriters() {
        return writers;
    }

    public void setWriters(writer[] writers) {
        this.writers = writers;
    }
}
class librarian extends person implements Serializable {
    public librarian(String firstname, String lastname, int id, int age) {

        super(firstname, lastname, id, age);
    }
}
class library implements Serializable {
    private String name;
    private member[] members=new member[10];
    private book[] books=new book[10];
    private book[] borrowed=new book[10];
    private book[] notborrowed=new book[10];
    private borrow[] borrows=new borrow[10];

    public library(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public member[] getMembers() {
        return members;
    }

    public void setMembers(member[] members) {
        this.members = members;
    }

    public book[] getBooks() {
        return books;
    }

    public void setBooks(book[] books) {
        this.books = books;
    }

    public book[] getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(book[] borrowed) {
        this.borrowed = borrowed;
    }

    public book[] getNotborrowed() {
        return notborrowed;
    }

    public void setNotborrowed(book[] notborrowed) {
        this.notborrowed = notborrowed;
    }

    public borrow[] getBorrows() {
        return borrows;
    }

    public void setBorrows(borrow[] borrows) {
        this.borrows = borrows;
    }

    public void addborrowedbooks(book book) {
        for (int i = 0; i <notborrowed.length ; i++) {
            if(notborrowed[i]==book){
                books[i]=null;
                for (int j = 0; j <borrowed.length ; j++) {
                    if(borrowed[j]==null){
                        borrowed[j]=book;
                        break;
                    }
                }
                break;
            }
        }
    }

    public void removeborrowedbooks(book book) {
        for (int i = 0; i <borrowed.length ; i++) {
            if(borrowed[i]==book){
                books[i]=null;
                for (int j = 0; j <notborrowed.length ; j++) {
                    if(notborrowed[j]==book){
                        notborrowed[j]=null;
                        break;
                    }
                }
                break;
            }
        }
    }
    public void addborrowed(borrow borrow){
        for (int i = 0; i <borrows.length ; i++) {
            if(borrows[i]==null){
                borrows[i]=borrow;
                break;
            }
        }
    }
    public void addmember(member member){
        for (int i = 0; i <members.length ; i++) {
            if(members[i]==null){
                members[i]=member;
                break;
            }
        }
    }
    public void addbook(book book){
        for (int i = 0; i <books.length ; i++) {
            if(books[i]==null){
                books[i]=book;
                addnotborrowed(book);
                break;
            }
        }
    }
    public void addnotborrowed(book book){
        for (int i = 0; i <notborrowed.length ; i++) {
            if(notborrowed[i]==null){
                notborrowed[i]=book;
                break;
            }
        }
    }
    public member getmember(int id){
        for (member member : members) {
            if (member != null) {
                if (member.getId() == id) {
                    return member;
                }
            }
        }
        return null;
    }
    public book getbook(int id){
        for (book book : books) {
            if (book != null) {
                if (book.getId() == id) {
                    return book;
                }
            }
        }
        return null;
    }
    public borrow getborrow(int id){
        for (int i = 0; i <borrows.length ; i++) {
            if(borrows[i]!=null){
                if(borrows[i].getId()==id){
                    return borrows[i];
                }}
        }return null;
    }

}
class member extends person implements Serializable {
    private address address;
    public member(String firstname, String lastname, int id, address address) {
        super(firstname, lastname, id);
        this.address=address;
    }

    public address getAddress() {
        return address;
    }
}
class person implements Serializable {
    protected String firstname;
    protected String lastname;
    protected int id;
    protected int age;

    public person(String firstname, String lastname, int id, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
        this.age = age;
    }

    public person(String firstname, String lastname, int id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.id = id;
    }

    public person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
class writer extends person implements Serializable {
    public writer(String firstname, String lastname) {
        super(firstname, lastname);
    }
}