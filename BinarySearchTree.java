package com.example;

public class BinarySearchTree {
    Node <Patient> root;
    public BinarySearchTree(){
        root=null;
    }
    public Node <Patient> insert (Patient data){
        if (root==null) {
            return root=new Node<Patient>(data);
        }else{
            return insertRec(root, data);
        }
    }
    public Node <Patient> insertRec(Node<Patient> node,Patient patient){
        if (node==null) {
            return new Node<Patient>(patient);
        }
        if (patient.getId()>node.data.getId()) {
            node.right=insertRec(node.right,patient);
        }else if (patient.getId()<node.data.getId()){
            node.left=insertRec(node.left,patient);
        }else{
            System.out.println("patient already exists");
        }
        return node;
    }
    public Patient search(int id){
        return searchRec(root, id);
    }
    public Patient searchRec(Node<Patient> root, int id){
        if (root == null) {
            System.out.println("patient not found");
            return null;
        }else if (root.data.getId()<id) {
            return searchRec(root.right, id);
        }else if (root.data.getId()>id) {
            return searchRec(root.left, id);
        }else{
            return root.data;
        }
    }
    // public Node<Patient> delete(Patient patient)  {
    //     return deleteRec(root, patient);
    // }
    // public Node<Patient> deleteRec(Node<Patient> node, Patient patient) {
    //     if (node==null) {
    //         System.out.println("patient not found");
    //         return null;
    //     }
    //     if (patient.getId()<node.data.getId()) {
    //         node.left=deleteRec(node.left, patient);
    //     }else if (patient.getId()>node.data.getId()) {
    //         node.right=deleteRec(node.right, patient);
    //     }else if (patient.getId()==node.data.getId()) {
    //         if (node.left==null && node.right==null) {//has no children (leafe node)//
    //             node =null;
    //             return node;
    //         }else if (node.left==null) {//has right child//
    //             node =node.right;
    //             return node;
    //         }else if (node.right==null) {//has left child
    //             node =node.left;
    //             return node;
    //         }else{//has 2 childrens (mesh fahmo :( )//
    //             Node<Patient>smallest=getSuccessor(node);
    //             node.data=smallest.data;
    //             node.right=deleteRec(node.right, smallest.data);
    //         }
    //     }
    //     return node;
    // }
    // public Node<Patient> getSuccessor(Node<Patient> node) {
    //     Node<Patient> temp=node.right;
    //     while(temp.left!=null) {
    //         temp=temp.left;
    //     }
    //     return temp;
    // }
}
