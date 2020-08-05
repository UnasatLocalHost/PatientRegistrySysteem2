package sr.unasat.patient.app;


import sr.unasat.patient.service.Services;

public class Application {


    public static void main(String[] args) {

        Services.Node node = new Services.Node(1,"First Patient");
//        node.insert(2,"Second Patient");
//        node.insert(3,"third Patient");
//        node.insert(4,"fourth Patient");
//        node.insert(5,"fifth patient");
//        node.insert(6,"sixth patient");
//        node.insert(7,"seventh patient");

        node.left = new Services.Node(2,"second patient");
//
//        System.out.println("InOrder traversal  of the given tree");
//        node.inOrderRecord(node);

        node.right = new Services.Node(3,"third patient");
        node.left.left = new Services.Node(4,"fourth patient");
        node.left.right = new Services.Node(5,"fifth patient");
        node.right.left = new Services.Node(6,"sixth patient");
        node.right.right = new Services.Node(7,"seventh patient");

        node.convert(node);


        int id = 2;

        if (node.ifNodeExists(node,id))
            System.out.println("yes, patient with the ID "+ id + " " + "was found in the system");

        else
            System.out.println("No, patient with the id"+ id + "was not found in the system");




    }

}
