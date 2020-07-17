import java.util.ArrayList;

public class Originator {
    private int id;
    private String name;
    private int age;

    public Originator(int id,String name,int age){
        this.id =id;
        this.name =name;
        this.age =age;
    }

    public void setId(int id){
        this.id =id;
    }

    public void setName(String name){
        this.name =name;
    }
    public void setAge(int age){
        this.age =age;
    }

    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public void viewDetails(){
        System.out.println(id+" - "+name+" - "+age);
    }

    public void saveMemento(Caretaker1 caretaker){
        Memento memento = new Memento(id,name,age);
        caretaker.addMemeto(memento);
    }

    public void restoreMemento(Memento memento){
        this.id =memento.getId();
        this.name =memento.getName();
        this.age =memento.getAge();
    }

    static class Memento{
        private final int id;
        private final String name;
        private final int age;

        public Memento(int id,String name,int age){
            this.id =id;
            this.name =name;
            this.age =age;
        }

        public int getId(){
            return this.id;
        }

        public String getName(){
            return this.name;
        }

        public int getAge(){
            return this.age;
        }
    }
}

class Caretaker1{
    private final ArrayList<Originator.Memento> list = new ArrayList<Originator.Memento>();

    public void addMemeto(Originator.Memento m){
        list.add(m);
    }

    public Originator.Memento getMemento(int index){
      return list.get(index);
    }
}

class Test1{
    public static void main(String[] args) {
        Caretaker1 caretaker =new Caretaker1();

        Originator student = new Originator(1,"Eshan",22);
        student.saveMemento(caretaker);
        student.viewDetails();

        student.setAge(23);
        student.saveMemento(caretaker);

        student.setAge(25);
        student.saveMemento(caretaker);

        student.setAge(25);
        student.saveMemento(caretaker);
        student.setAge(24);
        student.saveMemento(caretaker);
        student.setAge(26);
        student.saveMemento(caretaker);

        student.restoreMemento(caretaker.getMemento(4));
        student.viewDetails();

        student.restoreMemento(caretaker.getMemento(3));
        student.viewDetails();
    }
}
