# HW6 - Sample Grader Classes 

## Setup
In order to copy these sample grader classes into the same level directory as your ExpressionTree and BetterBST classes, open a new terminal and invoke the following commands:

```
cp SampleGraderClasses/ExpressionTreeGrader.class ExpressionTreeGrader.class
cp SampleGraderClasses/BetterBSTGrader.class BetterBSTGrader.class 
```

You need to perform this step only once. Please do not delete or change any files within this SampleGraderClasses directory. If you accidentally delete a sample grader class, these binary files can be accessed on Courseworks. 

## P1 - ExpressionTreeGrader

Our sample ExpressionTreeGrader checks your ExpressionTree constructor and eval(), postfix(), prefix() methods on the below test cases. These tests are in no way exhaustive (neither of the requirements nor the edge cases), e.g. we are not testing infix() here. As such, please perform additional testing on your classes. These released tests make up about a third of the the test cases you will be graded with. 

**Test Case 1: "4"**
- eval() result: 4
- prefix() result: "4"
- postfix() result: "4"

**Test Case 2: "2 3 + 8 4 / \*"**
- eval() result: 10
- prefix() result: "* + 2 3 / 8 4"
- postfix() result: "2 3 + 8 4 / *"

**Test Case 1: "2 \*"**
This is an invalid postfix expression due to stack underflow. In such a case, you may throw an exception like so (similarly when a non empty stack is encountered):

```
throw new Exception("Stack Underflow: Invalid postfix expression.");
```

## P2 - BetterBSTGrader

#### Test Case 1:
This test case checks your handling of a null BetterBST object. On the below tree object (that is null) we run your height(), imbalance(), smallestGreaterThan(), mirror(), and levelOrderTraversal() methods. 
```
BetterBST<Integer> tree = null;
tree = new BetterBST<>(); 
```
The expected return values of the height(), imbalance(), smallestGreaterThan(), and levelOrderTraversal() methods are as follows:
- Expected height() return: -1
- Expected imbalance() return: null
- Expected smallestGreaterThan(0) return: null
- Expected levelOrderTraversal() return: an empty LinkedList (new LinkedList<>())

#### Test Case 2: 
This test case uses a single node BetterBST, valued 5, on which your your height(), imbalance(), smallestGreaterThan(), mirror(), and levelOrderTraversal() methods are ran.

To simulate this, you may insert(5) after instantiating a new BetterBST of Integers. 
The expected return values of the height(), imbalance(), smallestGreaterThan(), and levelOrderTraversal() methods are as follows:
- Expected height() return: 0
- Expected imbalance() return: null
- Expected smallestGreaterThan(4) return: 5
- Expected levelOrderTraversal() return: a LinkedList containing only 5 (new LinkedList<> (Arrays.asList(5))).

#### Test Case 3: 
Now, we insert and test a BetterBST also containing an 8 (in addition to the 5 from test case 2).
To simulate this, you may insert(5) and insert(8) after instantiating a new BetterBST of Integers.

he expected return values of the height(), imbalance(), smallestGreaterThan(), and levelOrderTraversal() methods are as follows:
- Expected height() return: 1
- Expected imbalance() return: null
- Expected smallestGreaterThan(6) return: 8
- Expected levelOrderTraversal() return: a LinkedList containing 5, 8 (new LinkedList<> (Arrays.asList(5, 8)))

A reminder that these tests are in no way exhaustive (neither of the requirements nor the edge cases), e.g. we are not testing you with a case that has an imbalance. As such, please perform additional testing on your classes. These released tests make up about a third of the the test cases you will be graded with. 