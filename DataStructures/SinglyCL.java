import java.util.*;

class node
{
    public int data;
    public node next;
    public node prev;
}

class LinkedList
{
    public node head;
    public node tail;
    public int iCount;

    LinkedList()
    {
        head = null;
        tail = null;
        iCount = 0;
    }

   public void InsertFirst(int no)
    {
       node newn = null;
       newn = new node();
       newn.data = no;
       newn.next = null;

       if((head == null) && (tail == null))
       {
          head = newn;
          tail = newn;

       } 
       else
       {
         newn.next = head;
         head = newn;
         
       }
       tail.next = head;
       iCount++;
    }
    public void InsertLast(int no)
    {
        node newn = null;
       newn = new node();
       newn.data = no;
       newn.next = null;

       if((head == null) && (tail == null))
       {
          head = newn;
          tail = newn;

       } 
       else
       {
           tail.next = newn;
           tail = newn;
       }
       tail.next = head;
       iCount++;
    }
    public void DeleteFirst()
    {
        if((head == null) && (tail == null))
        {
            return;
        }
        else if(head == tail)
        {
            head = null;
            tail = null;
        }
        else
        {
            node temp = null;
            temp = head;
            head = head.next;
            tail.next = head;
        }
        System.gc();
        iCount--;
    }

     public void DeleteLast()
     {
        if((head == null) && (tail == null))
        {
            return;
        }
        else if(head == tail)
        {
            head = null;
            tail = null;
            System.gc();
        }
        else
        {
            node temp = null;
            temp = head;
            while(temp.next != tail)
            {
                temp = temp.next;
            }
            tail = temp;
            tail.next = head;
        } 
        iCount--; 
     }
     public void InsertAtPos(int no, int iPos)
     {
        if(iPos < 1 || iPos > iCount + 1)
        {
            System.out.println("Invalid position.");
        }
        if(iPos == 1)
        {
            InsertFirst(no);
        }
        else if(iPos == iCount+1)
        {
            InsertLast(no);
        }
        else
        {
            int i = 0;
            node newn = null;
            node temp = null;
            newn = new node();
            newn.data = no;
            newn.next = null;
            temp = head;

            for(i = 1; i < iPos-1; i++)
            {
                temp = temp.next;
            }
            newn.next = temp.next;
            temp.next = newn;
            iCount++;
        }     
     }
     public void DeleteAtPos(int iPos)
     {
        if(iPos < 1 || iPos > iCount)
        {
            System.out.println("Invalid position.");
        }
        if(iPos == 1)
        {
            DeleteFirst();
        }
        else if(iPos == iCount)
        {
            DeleteLast();
        }
        else
        {
            int i = 0;
            node temp = null;
            node target = null;

            temp = head;

            for(i = 1; i < iPos-1; i++)
            {
               temp = temp.next;
            }
            target = temp.next;
            temp.next = target.next;
            target = null;
            System.gc();
            iCount--;
        }
     }
    public void Display()
    {
           System.out.println();
           System.out.println("Linked List is : ");
           
        if((head == null) && (tail == null))
        {
            System.out.println("LinkedList is Empty.");
        }
        if(head == tail)
        {
            System.out.println("Linked List contains only one node.");
        }

     
        do
        {
            System.out.print("|"+head.data+"| -> ");
            
            head = head.next;
        }while(head != tail.next);
        System.out.println();
    }
    public int Count()
    {
        return iCount;
    }
}
class SinglyCL
{
    public static void main(String args[])
    {
        LinkedList lobj = new LinkedList();
        int iRet = 0;

        lobj.InsertFirst(51);
        lobj.InsertFirst(21);
        lobj.InsertFirst(11);
        lobj.InsertLast(101);
        lobj.InsertLast(111);
        lobj.InsertLast(121);
        lobj.Display();
        iRet = lobj.Count();
        System.out.println("Number of elements : "+iRet);
    
        lobj.DeleteFirst();
        lobj.Display();
        iRet = lobj.Count();
        System.out.println("Number of elements : "+iRet);

        lobj.DeleteLast();
        lobj.Display();
        iRet = lobj.Count();
        System.out.println("Number of elements : "+iRet);

        lobj.InsertAtPos(71,4);
        lobj.Display();
        iRet = lobj.Count();
        System.out.println("Number of elements : "+iRet);

        lobj.DeleteAtPos(4);
        lobj.Display();
        iRet = lobj.Count();
        System.out.println("Number of elements : "+iRet);
    }
}