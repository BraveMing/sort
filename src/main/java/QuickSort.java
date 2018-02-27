/**
 * 快速排序
  */
public class QuickSort{
        public static void quickSort(Comparable[] a){  
            //StdRandom.shuffle(a);//将数组a顺序打乱，消除对输入的依赖，这是《算法第四版》作者写好的静态函数，  
            quickSort(a, 0, a.length-1);  
        }  
        public static void quickSort(Comparable[] a, int lo, int hi){  
            if(hi <= lo)    //跳出递归的条件，相当于不能再分解了  
                return;  
            int j = partition(a, lo, hi);    //切分（将a[lo]插入到数组中合适的位置：左边比他小，右边比它大，这样就将数组切分成两部分）  
            quickSort(a, lo, j-1);           //将左半部分a[lo...j-1]排序  
            quickSort(a, j+1, hi);           //将右半部分a[j+1...hi]排序  
        }  
        private static int partition(Comparable[] a, int lo, int hi){  
        //将数组切分为a[lo...i-1]、a[i] 和a[i+1...hi];  
            int i = lo, j = hi + 1;   //左右扫描的指针,j=hi+1,很大的程度上是为了下面写--j，  
            Comparable v = a[lo];     //把要用来切分的元素保留  
            while(true){              // 扫描左右检查扫描是否结束并交换元素  
                while(less(a[++i], v))//两种条件会跳出while循环，直到在左侧找到比v大的，或i指针已经走到头了（i==hi）,++i的原因：v是从lo开始的，满足less（）  
                    if(i == hi)   break;//不过这两个判断越界的测试条件是多余的，可以去掉，因为本身i,j就是从两端走过去的，不等走到头就  
                while(less(v,a[--j]));  
                    if(j == lo)   break;  
                if(i >= j)    break;  //i和j碰上了，那就跳出整个循环，  
                exch(a,i,j);          //如果上两个while都跳出，说明i，j停在了a[i]>v ，a[j]<v处，所以将二者交换就可以了，然后i和j继续向中间靠拢  
            }  
            exch(a, lo, j);           //将  v = a[j]放入正确的位置,当两个指针相遇时，交换a[lo]和a[j]，这样切分的值就留在a[j]中了，初始的a[lo]找到了正确位置  
            return j;                 //a[lo...j-1] <= a[j] <= a[j+1...hi]达成  
        }

        private static boolean less(Comparable v, Comparable comparable) {
            return v.compareTo(comparable)<0;
        }

        private static void exch(Comparable[] a, int i, int j) {
            Comparable temp;
            temp=a[i];
            a[i]=a[j];
            a[j]=  temp;
        }
    }  