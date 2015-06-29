import java.util.Random;

/*
 * Basic Games Library
 *
 * Functions :
 ***************************************************************************
 ************************ Random numbers ***********************************
 ***************************************************************************
 * Random numbers 
 * ====> RndInt & overload (3)
 * (1) default RndInt 
 * ==> a random number
 * int RndInt (int i) ;  
 * Use case 
 * --------
 * quickly get a random number
 *
 * 
 * 
 * (2) overload 
 * ==> return a random number between and included lower and higher 
 * int RndInt (int i , int i) * overload + bound ; return rndint + bound
 * Use case 
 * --------
 * get random ages between 18 and 55
 *
 * 
 * (3) overload random number
 * ==>return a random number between lower and higher , excluding from possible results a particular value "noVal"  
 * int RndInt(int i , int bound , int noVal)
 * Use case 
 * --------
 * get random number from -4 to +4 but no 0
 * 
 * RndPick
 * ==>return a random value of any type ex: integer or integer , double or double or int or double , string or int , string or char etc ...  
 * <T>T RndPick(T ... val)
 * Use case 
 * --------
 * get random value from a set of two or more arguments
 * error handling 
 * if no arguments return obj address 
 * 
 * */
//node
class node<T>{
	T val;
	node next;
	node (T val){
		this.val=val;
	}	
}
//making the linked list
class linkedList<T>{
node first ;	
	linkedList(){
		first=null;
	}
	
	boolean isEmpty(){return first==null;}
	void add(T val){
		if (isEmpty()){
			first = new node (val);
			return ;
		}
		else {
			node tmp = new node(val);
			tmp.next=first;
			first=tmp;
		}
	}
	//
	void delete(T val){
		if (isEmpty())
			return ;
		else if (first.val==val){
			System.out.println("Deleting first : "+first.val);
			first=first.next;
			return;
		}
		else {
			node tmp=first;
			node prec=null;
			while (tmp.next!=null){				
				if (tmp.val==val){
					System.out.println("Deleting middle : "+tmp.val);
					prec.next=tmp.next;
					return;
				}
				prec=tmp;
				tmp=tmp.next;				
			}			
			System.out.println("Deleting last : "+prec.next.val);
			prec.next=null;
		}
	} 
	//
	void show(){
		System.out.println("T_______");
		node tmp=first;
		while(tmp!=null){
			System.out.println("display from list "+tmp.val);
			tmp=tmp.next;
		}
	}
	
}



public class BGL {
	//***************************************************************************
	//************************ Random numbers ***********************************
	//***************************************************************************
	//basic random integer number
	public static int RndInt(int i) {
		Random nn = new Random();
		return nn.nextInt(i);
	}
	//overload + bound
	public static int RndInt(int i , int bound) {
		Random nn = new Random();
		return nn.nextInt(i)+bound;
	}
	//overload + noVal
	//value excluded example 0
	public static int RndInt(int i , int bound , int noVal){
		int val=RndInt(i,bound);
		if (val==noVal)return RndInt(i,bound,noVal);
		return val;
	}
	//overload + bound
	//value excluded example [-2,2]
	public static int RndInt(int i , int bound , int noValStart , int noValEnd){
		int val=RndInt(i,bound);
		if (val>=noValStart && val<=noValEnd)return RndInt(i,bound,noValStart , noValEnd);
		return val;
	}
	
	//______________________________________________________________________________________
	//rand pick and delete one of n elms until the list is empty 
	public static <T>T RndPick(T ... val){
		linkedList l = new linkedList();
		add (l,val);
			l.show();
			
			for (int i=0;i<val.length;i++)
				delete(l,val[i]);
					l.show();	
		return (T) ((val.length>0)?val[RndInt(val.length)]:val);
	}
	//sub
	private static <T> void add(linkedList l , T [] val ){
		for (int i=0;i<val.length;i++)
		l.add(val[i]);
		
	} 
	//sub
	private  static <T> linkedList delete(linkedList l,T j ){
		l.delete(j);		
		return l;
	} 
	
	//______________________________________________________________________________________
	//Collision 
	// point to square
	public static boolean ptRect(int ptx , int pty  , int rectx , int recty , int size){
	if (ptx>rectx && ptx<rectx+size && pty>recty && pty<recty+size )
		return true;
		return false;
	}
	// point to rectangle
	public static boolean ptRect(int ptx , int pty  , int rectx , int recty , int sizex , int sizey){
	if (ptx>rectx && ptx<rectx+sizex && pty>recty && pty<recty+sizey )
		return true;
		return false;
	}

	//square to rectangle
	/*
	public static boolean sqrRect(int sqrx , int sqry ,int sqrSize , int rectx , int recty , int sizex , int sizey){
		if (sqrx>rectx && (sqrx+sqrSize)<rectx+sizex && sqry>recty && (sqry+sqrSize)<recty+sizey )
			return true;
			return false;
		}
*/
	
	
	
}

