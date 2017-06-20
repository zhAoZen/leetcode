package com.ze.offer;

public class 二叉树的镜像 {
	public class BinaryTreeNode{
		int data;
		BinaryTreeNode right;
		BinaryTreeNode left;
	}
	public void MirrorRecuresively(BinaryTreeNode pNode){
		if(null==pNode||(null==pNode.left)&&(null==pNode.right)){
			return ;
		}
		BinaryTreeNode temp=null;
		temp=pNode.left;
		pNode.left=pNode.right;
		pNode.right=temp;
		if(pNode.right!=null){
			MirrorRecuresively(pNode.right);
		}
		if(pNode.left!=null){
			MirrorRecuresively(pNode.left                                );
		}
	}
}
