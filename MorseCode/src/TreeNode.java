public class TreeNode
{
  private char value;
  private TreeNode left;
  private TreeNode right;

  // Constructors:

  public TreeNode(char initValue)
  {
    value = initValue;
    left = null;
    right = null;
  }

  public TreeNode(char initValue, TreeNode initLeft, TreeNode initRight)
  {
    value = initValue;
    left = initLeft;
    right = initRight;
  }

  // Methods:

  public char getValue() { return value; }
  public TreeNode getLeft() { return left; }
  public TreeNode getRight() { return right; }
  public void setValue(char theNewValue) { value = theNewValue; }
  public void setLeft(TreeNode theNewLeft) { left = theNewLeft; }
  public void setRight(TreeNode theNewRight) { right = theNewRight; }
}
