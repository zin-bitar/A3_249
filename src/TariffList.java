import java.util.NoSuchElementException;

public class TariffList implements TariffPolicy{

    private TariffNode head;



    private int size;

    public TariffList(){
        head = null;
        size = 0;
    }

    public TariffList(TariffList copy) {
        if(copy.head == null){
            this.head = null;
            this.size = 0;
            return;
        }
        this.head = new TariffNode(copy.head.tariff.clone(), null);
        TariffNode current = head;
        TariffNode other = copy.head.next;
        while(other != null){
            TariffNode newNode = new TariffNode(other.tariff.clone(), null);
            current.next = newNode;
            current = newNode;
            other = other.next;
        }
        this.size = copy.size;
    }

    public void addToStart(Tariff tariff){
        this.size++;
        head = new TariffNode(tariff, head);
    }

    public void insertAtIndex(Tariff tariff, int index){
        try{
        if (index < 0 || index > size - 1)
                throw new NoSuchElementException("No such element index");}
        catch(IndexOutOfBoundsException e){
        System.out.println("Index out of bounds");
        System.exit(0);
        }

        if(index == 0)
            addToStart(tariff);
        else{
        TariffNode current = head;
        for (int i = 0; i < index-1; i++) {
            current = current.getNext();
        }
        TariffNode newNode = new TariffNode(tariff, current.getNext());
        current.setNext(newNode);
        size++;}
    }

    public void deleteFromIndex(int index){
        try{
            if (index < 0 || index > size - 1)
                throw new NoSuchElementException("No such element index");}
        catch(IndexOutOfBoundsException e){
            System.out.println("Index out of bounds");
            System.exit(0);}
        if(index == 0)
            deleteFromStart();
        else{
        TariffNode current = head;
        for (int i = 0; i < index-1; i++) {
            current = current.getNext();
        }
        current.setNext(current.getNext().getNext());
        size--;}
    }


    public boolean deleteFromStart(){
        if(head != null){
            head = head.getNext();
            return true;}
        else return false;
    }

    public void replaceAtIndex(Tariff tariff, int index){
        if (index < 0 || index > size - 1)
            return;
        TariffNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        current.tariff = tariff.clone();
    }

    public TariffNode find(String origin, String destination, String category){
        TariffNode current = head;
        int iterations = 0;
        while(current != null){
            iterations++;
            Tariff tariff = current.tariff;
            if(tariff.getOriginCountry().equalsIgnoreCase(origin) && tariff.getDestinationCountry().equalsIgnoreCase(destination) && tariff.getProductCategory().equalsIgnoreCase(category)){
                System.out.println(iterations + " iterations");
                return current;}
            current = current.getNext();
        }
        System.out.println("Not found after " + iterations + " iterations");
        return null;
    }

    public boolean contains(String origin, String destination, String category){
        TariffNode current = head;
        while(current != null){
            Tariff tariff = current.tariff;
            if(tariff.getOriginCountry().equalsIgnoreCase(origin) && tariff.getDestinationCountry().equalsIgnoreCase(destination) && tariff.getProductCategory().equalsIgnoreCase(category)){
            return true;}
            current = current.getNext();
        }
        return false;
    }


    public boolean equals(TariffList o){
        if(this == o) return true;
        if(o == null) return false;
        if(this.size != o.size) return false;
        TariffNode current = this.head;
        TariffNode other = o.head;
        while(current != null && other != null){
            if(!current.getTariff().equals(other.getTariff())) return false;
            current = current.getNext();
            other = other.getNext();
        }
        return true;
    }

    public void outputList(){
        TariffNode position = head;
        while(position != null){
            System.out.println(position.getTariff().toString());
            position = position.getNext();
        }
    }

    @Override
    public String evaluateTrade(double proposedTariff, double minimumTariff) {
        String output = "";
        if (0.8 * minimumTariff > proposedTariff) {
            output = "Rejected";}
        else if (minimumTariff <= proposedTariff) {
            output = "Accepted";
        } else if (0.8 * minimumTariff <= proposedTariff) {
            output = "Conditional";
        }
        return output;
    }

    public class TariffNode{

        private Tariff tariff;
        private TariffNode next;

        public TariffNode() {
            tariff = null;
            next = null;
        }

        public TariffNode(Tariff tariff, TariffNode next) {
            this.tariff = tariff;
            this.next = next;
        }
        public TariffNode(TariffNode copy) {
            this.tariff = copy.getTariff();
            this.next = copy.getNext();
        }
        public TariffNode clone(){
            return new TariffNode(this.tariff.clone(), this.next);
        }

        public boolean equals(Object o) {
            if(this == o) return true;
            if(o == null || this.getClass() != o.getClass()) return false;
            TariffNode other = (TariffNode) o;
            return this.tariff.equals(other.tariff) && this.next.equals(other.next);
        }

        public Tariff getTariff() {
            return tariff;
        }

        public void setTariff(Tariff tariff) {
            this.tariff = tariff;
        }

        public TariffNode getNext() {
            return next;
        }

        public void setNext(TariffNode next) {
            this.next = next;
        }
    }
}
