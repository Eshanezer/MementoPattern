import java.util.ArrayList;

public class User {
    private int id;
    private String name;
    private String city;

    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void viewDetails(){
        System.out.println(id+" - "+ name +" - "+city);
    }
    public void saveMemento(Caretaker caretaker){
        Memento memento = new Memento(id,name,city);
        caretaker.addMemento(memento);
    }

    public void restoreMemento(Memento memento){
        this.id = memento.getId();
        this.name =memento.getName();
        this.city = memento.getCity();
    }

    static class Memento{
        private final int id;
        private final String name;
        private final String city;

        public Memento(int id, String name, String city) {
            this.id = id;
            this.name = name;
            this.city = city;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getCity() {
            return city;
        }
    }
}

class Caretaker{
    private final ArrayList<User.Memento> mementos= new ArrayList<>();

    public void addMemento(User.Memento m){
        this.mementos.add(m);
    }
    public User.Memento getMemento(int index){
        return this.mementos.get(index);
    }
}

class Test{
    public static void main(String[] args) {
        Caretaker caretaker = new Caretaker();

        User u1 = new User(1,"Eshan","Colombo");
        u1.viewDetails();
        u1.saveMemento(caretaker);

        u1.setCity("Kaluthara");
        u1.viewDetails();
        u1.saveMemento(caretaker);

        u1.setCity("Badulla");
        u1.viewDetails();
        u1.saveMemento(caretaker);

        u1.restoreMemento(caretaker.getMemento(0));
        u1.viewDetails();


        u1.restoreMemento(caretaker.getMemento(2));
        u1.viewDetails();
    }
}