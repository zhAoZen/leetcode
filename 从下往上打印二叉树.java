package com.ze.offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class 从下往上打印二叉树 {
	class TreeNode {
		int value;
		TreeNode leftChild;
		TreeNode rightChild;
		TreeNode(int value){
			this.value=value;
		}
		public void setLeft(TreeNode l){
			this.leftChild=l;
		}
		public void setRight(TreeNode r){
			this.rightChild=r;
		}
	}

	Deque<TreeNode> q=LinkedList<TreeNode>();
	public void syso(TreeNode root) {
		if(root==null)return ;
		TreeNode t=root;
		q.push(root);
		while(q.size()>0){
			t=q.peek();
			q.pop();
			System.out.println(t.value);
			
			if(t.leftChild!=null){
				q.add(t.leftChild);
			}
			if(t.rightChild!=null){
				q.add(t.rightChild);
			}
		}
	}
	

	
	@Test
	public void Test(){
		TreeNode root=new TreeNode(8);
		TreeNode root1=new TreeNode(6);
		TreeNode root2=new TreeNode(10);
		TreeNode root3=new TreeNode(5);
		TreeNode root4=new TreeNode(7);
		TreeNode root5=new TreeNode(9);
		TreeNode root6=new TreeNode(11);
		
		
		root.setLeft(root1);
		root.setRight(root2);
		root1.setLeft(root3);
		root1.setRight(root4);
		root2.setLeft(root5);
		root2.setRight(root6);
		syso(root);
	}
}
