package dexter.ir.type;

/**
 * Created by Maaz Ahmad on 6/25/19.
 */
public class PtrT extends CollectionT
{
  protected PtrT(Type elemT)
  {
    super(1, elemT);
  }

  @Override
  public boolean equals (Object o)
  {
    if (o instanceof PtrT)
    {
      PtrT oA = (PtrT)o;
      return oA.elemT.equals(elemT) && oA.dim == dim;
    }
    return false;
  }

  @Override public String toString () { return "ptr(" + elemT + ")"; }

  @Override public void print() { System.out.println(toString()); }
}