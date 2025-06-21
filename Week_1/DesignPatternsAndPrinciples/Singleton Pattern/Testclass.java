public class Testclass {
    public static void main(String[] args){
            Logger l1=Logger.getInstance();
            Logger l2=Logger.getInstance();

            System.out.println("Logger 1 hashcode: "+l1.hashCode());
            System.out.println("Logger 2 hashcode: "+l2.hashCode());
            
            if(l1==l2)
            System.out.println("Both l1 and l2 are same instance");
            else
            System.out.println("Both l1 and l2 are different");
        }
}
