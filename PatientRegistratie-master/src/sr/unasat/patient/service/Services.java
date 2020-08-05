package sr.unasat.patient.service;


public class Services {


    public static class Node {
        int patientID;
        String patientName;
        public Node left, right = null;

        public Node(int patientID, String patientName) {
            this.patientID = patientID;
            this.patientName = patientName;
        }


        // root of the node
        public Node root;





        public static void printDLL(Node head) {
            Node curr = head;
            while (curr != null) {
                System.out.println(curr.patientID + " : " + curr.patientName);
                curr = curr.right;
            }
        }

        //function to convert binary tree into a Doubly linked list
        // by doing normal inorder traversal

        public static Node convert(Node root, Node head) {
            //base case: tree is empty

            if (root == null) {
                return head;
            }
            //recursively convert left subtree first
            head = convert(root.left, head);


            //store right child
            Node right = root.right;

            //insert current node in the beginning of DLL
            root.right = head;
            if (head != null) {
                head.left = root;
            }
            head = root;
            //recursively convert right subtree
            return convert(right, head);
        }

        //function  to reverse a DLL
        public static Node reverse(Node head) {
            Node prev = null;
            Node current = head;

            while (current != null) {
                //swap current.left with current current.right

                Node temp = current.left;
                current.left = current.right;
                current.right = temp;

                prev = current;
                current = current.left;
            }
            return prev;
        }

        //main function  to in-place convert given binary tree to a DLL
        public static void convert(Node root) {
            //head of the DLL
            Node head = null;

            //convert above binary tree  to DLL
            head = convert(root, head);

            //reversed the linked list
            head = reverse(head);

            //print the list
            printDLL(head);

        }

        public static boolean ifNodeExists(Node node, int id) {
            if (node == null)
                return false;
            if (node.patientID == id)
                return true;

            // recur on left subtree
            boolean resultOne = ifNodeExists(node.left, id);
            if (resultOne) return true; //node was found, no need to look any further.

            // node was node found in left , so recur on right subtree

            boolean resultTwo = ifNodeExists(node.right, id);

            return resultTwo;
        }

        public void deletePatient(int patientID, String patientName) {
            root = deletePatientRecord(root, patientID, patientName);

        }

        Node deletePatientRecord(Node root, int patientID, String patientName) {
            // base Case 1: if the tree is empty
            if (root == null) return root;

            // Otherwise, recur down the tree
            if (patientID < root.patientID)
                root.left = deletePatientRecord(root.left, patientID, patientName);
            else if (patientID > root.patientID)
                root.right = deletePatientRecord(root.right, patientID, patientName);


                //if the ID is the same as the root id, then this is the node
                // to be deleted.
            else {
                //node with only one child or no child
                if (root.left == null)
                    return root.right;
                else if (root.right == null)
                    return root.left;


                // node with two children : get the inorder successor (smallest
                // in the right  subtree

                root.patientID = minValue(root.right);


                // Delete  the inorder successor

                root.right = deletePatientRecord(root.right, root.patientID, root.patientName);
            }
            return root;
        }

        public int minValue(Node root) {
            int min = root.patientID;
            while (root.left != null) {
                min = root.left.patientID;
                root = root.left;
            }
            return min;
        }

        //method that calls the insertRecord

        public void insert(int patientID, String patientName) {
            root = insertRecord(root, patientID, patientName);


        }
        // A recursive function to insert  an new  record in the Binary tree

        Node insertRecord(Node root, int patientID, String PatientName) {
            // if the the tree is empty, return  a new node
            if (root == null) {
                root = new Node(patientID, patientName);
                return root;
            }

            // otherwise , recur down the tree

            if (patientID < root.patientID)
                root.left = insertRecord(root.left, patientID, patientName);
            else if (patientID > root.patientID)
                root.right = insertRecord(root.right, patientID, patientName);

            return root;
        }

        // this method calls the inOrderRecord
        public void inOrder() {
            inOrderRecord(root);
        }

        // a utility function to do inorder traversal of the binary tree

        public void inOrderRecord(Node root) {
            if (root != null) {
                inOrderRecord(root.left);
                System.out.println(root.patientID + " : " + root.patientName);
                inOrderRecord(root.right);
            }
        }

    }



}