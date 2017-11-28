/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 吉彬
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Solution {
    public static void main(String[] args){
        
    }
    /*
    问题：
    输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
    */
    
    /*
    解决思路：
    首先要考虑特殊情况，当两个链表都为空时，其结果为空；当其中一个为空时，结果为另一个。
    然后考虑正常情况（两个都不为空时），找出两个链表中头节点值小者为合并后链表的头节点，
    再然后以头节点值小的链表的下一个节点为该链表的头节点与另一个链表头节点比较，较小者加到合并链表的尾部，
    以此类推，直到某一个链表为空，将另一个链表加到合并链表尾部。
    */
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null&&list2==null)//如果两个链表都为空
            return null;
        if(list1==null||list2==null)//如果其中的一个链表为空
            return list1==null?list2:list1;
        //两个链表都不为空
        ListNode head = list1.val<=list2.val?list1:list2;//合并链表头节点指向较小者
        ListNode p = head;//用来记住合并链表中的最后一个节点
        //头节点较小者的链表头节点指向该链表的下一个节点，从而得到该链表的子链表
        if(list1.val<=list2.val)
            list1 = list1.next;
        else
            list2 = list2.next;
        //通过循环遍历判断两个链表中头节点较小者并插入到合并链表中
        while(true){
            //一个链表已被遍历完而另一个链表还未被遍历完，或者两个链表都已被遍历完
            if(list1==null||list2==null)
                break;
            if(list1.val<=list2.val){
                p.next = list1;//将小者加入到合并链表
                p = p.next;//p指向合并链表最后一个节点
                list1 = list1.next;//较小者节点已被接入合并链表，让该链表的头指针指向下一个节点，构成一个新的子链表
            }
            else{
                p.next = list2;
                p = p.next;
                list2 = list2.next;
            }
        }
        if(list1==null)//如果list1为空，则将list2中剩余的节点接入合并链表
            p.next = list2;
        else//list2为空
            p.next = list1;
        
        return head;
    }
}
