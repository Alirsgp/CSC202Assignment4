public class Mergesort {

   // Ali Mohammadian
   

   public static void iterativeMergesort(int[] a) {
      int[] aux = new int[a.length];
      for (int sizeOfNode=1; sizeOfNode<a.length; sizeOfNode*=2)
         for (int start=0; start<a.length; start+=2*sizeOfNode)
            merge(a, aux, start, start+sizeOfNode, start+2*sizeOfNode);
   }

   public static void iterativeMergesortWithoutCopy(int[] a) {
      int[] from = a, to = new int[a.length];
      for (int sizeOfNode=1; sizeOfNode<a.length; sizeOfNode*=2) {
         for (int start=0; start<a.length; start+=2*sizeOfNode)
            mergeButDoNotCopy(from, to, start, start+sizeOfNode, start+2*sizeOfNode);
          int[] temp = from;
          from = to;
          to = temp;
      }
       if (a != from)
         for (int k = 0; k < a.length; k++)
            a[k] = from[k];
   }

    private static void mergeButDoNotCopy(int[] from, int[] to, int lo, int midpoint, int tp) {
       if (midpoint > from.length) midpoint = from.length;
       if (tp > from.length) tp = from.length;
       int i = lo, j = midpoint;
       for (int k = lo; k < tp; k++) {
          if      (i == midpoint)          to[k] = from[j++];
          else if (j == tp)           to[k] = from[i++];
          else if (from[j] < from[i]) to[k] = from[j++];
          else                        to[k] = from[i++];
       }
    }