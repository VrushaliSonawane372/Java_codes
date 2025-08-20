import java.util.*;

class Matrix
{
    public int Arr[][];

    public Matrix(int iRow, int iCol)
    {
        Arr = new int[iRow][iCol];
    }

    public void Accept()
    {
        System.out.println("Please enter the values : ");

        Scanner sobj = new Scanner(System.in);
        int i = 0, j = 0;

        for(i = 0; i < Arr.length;i++)
        {
            for(j = 0; j < Arr[i].length; j++)
            {
                Arr[i][j] = sobj.nextInt();
            }
        }
    }

    public void Display()
    {
        System.out.println("Elements of the matrix are : ");
        int i = 0, j = 0;

        for(i = 0; i < Arr.length;i++)
        {
            for(j = 0; j < Arr[i].length; j++)
            {
                System.out.print(Arr[i][j]+"\t");
            }
            System.out.println();
        }
    }


    public int Maximum()
    {
        int iMax = 0;
        int i = 0, j = 0;

        iMax = Arr[0][0];

        for(i = 0; i < Arr.length;i++)
        {
            for(j = 0; j < Arr[i].length; j++)
            {
                if(Arr[i][j] > iMax)
                {
                    iMax = Arr[i][j];
                }
            }
        }
        return iMax;
    }

    public int Minimum()
    {
        int iMin = 0;
        int i = 0, j = 0;

        iMin = Arr[0][0];

        for(i = 0; i < Arr.length;i++)
        {
            for(j = 0; j < Arr[i].length; j++)
            {
                if(Arr[i][j] < iMin)
                {
                    iMin = Arr[i][j];
                }
            }
        }
        return iMin;
    }
}

class MinMax
{
    public static void main(String Arg[])
    {
        int iRow = 0, iCol = 0, iRet = 0;

        Scanner sobj = new Scanner(System.in);

        System.out.println("Please enter number of rows : ");
        iRow = sobj.nextInt();

        System.out.println("Please enter number of columns : ");
        iCol = sobj.nextInt();
        
        Matrix mobj = new Matrix(iRow,iCol);

        mobj.Accept();
        mobj.Display();

        iRet = mobj.Maximum();

        System.out.println("Maximum element is : "+iRet);

        iRet = mobj.Minimum();

        System.out.println("Minimum element is : "+iRet);
    }
}