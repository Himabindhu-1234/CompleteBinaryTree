package JavaPackage;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class BTNode
{
BTNode left, right;
int data;


 /* Constructor */
public BTNode()
{
left = null;
right = null;
data = 0;
}
/* Constructor */
public BTNode(int n)
{
left = null;
right = null;
data = n;
}
/* Function to set left node */
public void setLeft(BTNode n)
{
left = n;
}
/* Function to set right node */
public void setRight(BTNode n)
{
right = n;
}
/* Function to get left node */
public BTNode getLeft()
{
return left;
}
/* Function to get right node */
public BTNode getRight()
{
return right;
}
/* Function to set data to node */
public void setData(int d)
{
data = d;
}
/* Function to get data from node */
public int getData()
{
return data;
}
}

/* Class BT */
class BT
{
private static BTNode root;

 /* Constructor */
public BT()
{
root = null;
}
/* Function to check if tree is empty */
public boolean isEmpty()
{
return root == null;
}
/* Functions to insert data */
public void insert(int data)
{
root = insert(root, data);
}
/* Function to insert data recursively */
private BTNode insert(BTNode node, int data)
{
String a = "r";
String b = "l";

if (node == null)
node = new BTNode(data);
else
{
Scanner scan = new Scanner(System.in);
System.out.println("Enter L for left and R for right : ");
String type = scan.nextLine();
{
if (a.equals(type)) {
node.right = insert(node.right, data);}
else if (b.equals(type))
{
node.left = insert(node.left, data);
}}}
return node;
}
public void postorder()
{
postorder(root);
}
private void postorder(BTNode r)
{
if (r != null)
{
postorder(r.getLeft());
postorder(r.getRight());
System.out.print(r.getData() +" ");
}
}
static boolean isCompleteBT(BTNode root)
{
// Base Case: An empty tree is complete Binary Tree
if(root == null)
return true;
// Create an empty queue
Queue<BTNode> queue =new LinkedList<>();
// Create a flag variable which will be set true
// when a non full node is seen
boolean flag = false;
// Do level order traversal using queue.
queue.add(root);
while(!queue.isEmpty())
{
BTNode temp_node = queue.remove();
/* Check if left child is present*/
if(temp_node.left != null)
{
// If we have seen a non full node, and we see a node
// with non-empty left child, then the given tree is not a complete Binary Tree
if(flag == true)
return false;
// Enqueue Left Child
queue.add(temp_node.left);
}
// set the flag as true for a non-full node,
else
flag = true;
/* Check if right child is present*/
if(temp_node.right != null)
{
// If we have seen a non full node, and we see a node
// with non-empty right child, then the given tree is not a complete Binary Tree
if(flag == true)
return false;
// Enqueue Right Child
queue.add(temp_node.right);
}
// for non-full node, set the flag as true
else
flag = true;
}
// tree is complete Binary Tree if we reach here
return true;
}
public static void main(String[] args)
{

Scanner scan = new Scanner(System.in);
/* Creating object of BT */
BT bt = new BT();
/* Perform tree operations */
System.out.println("Complete Binary Tree Test");

int n = 0;
System.out.print("Enter total number of nodes : ");
n = scan.nextInt();
for (int i = 0; i < n ; i++)
{
System.out.println("\nEnter integer element to insert :");
bt.insert( scan.nextInt() );
System.out.print("Order : ");
bt.postorder();

}
if(isCompleteBT(root) == true)
System.out.println("\nIt is a Complete Binary Tree!");
else
System.out.println("\nIt is not a Complete Binary Tree!");
}

 }
