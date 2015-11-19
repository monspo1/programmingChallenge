/* Basic Java Array List 
    https://www.interviewbit.com/courses/programming/topics/arrays/
//*/
public static void basicArrayList(ArrayList<Integer> a){

    // 1. Array declaration :
    ArrayList<Integer> A = new ArrayList<Integer>(); // declares an empty integer array. O(1)
    ArrayList<Integer> B = new ArrayList<Integer>(A); // creates a copy of list B.  O(size of B)

    // 2. Accessing ith element :
    A.get(i);     // O(1)

    // 3. Setting ith element :
    A.set(i, newValue);  // O(1)

    // 4. Size of the list :
    A.size();  // O(1) operation

    // 5. Adding elements to the list :
    A.add(newValue); // appends to the end of the list. O(1) operation. 
    A.add(index, newValue); // add the value at specified index. O(size - index) operation. 
    
}


static ArrayList<ArrayList<Integer>> performOps(ArrayList<ArrayList<Integer>> A) {
    
    ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
    for (int i = 0; i < A.size(); i++) {
        B.add(new ArrayList<Integer>());

        // 초기화 필요한 듯... 
        for (int j = 0; j < A.get(i).size(); j++) {
            B.get(i).add(0);
        }

        for (int j = 0; j < A.get(i).size(); j++) {
            B.get(i).set(A.get(i).size() - 1 - j, A.get(i).get(j));
        }
    }
return B;
}

/* The above java code is the same as the code (in C++) below

vector<vector<int> > performOps(vector<vector<int> > &A) {
    vector<vector<int> > B;
    B.resize(A.size());
    for (int i = 0; i < A.size(); i++) {
        B[i].resize(A[i].size());
        for (int j = 0; j < A[i].size(); j++) {
            B[i][A[i].size() - 1 - j] = A[i][j];
        }
    }
    return B;
}
//*/

//*/

//ex) A : [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]]
ArrayList<ArrayList<Integer>> B = performOps(A);
for (int i = 0; i < B.size(); i++) {
    for (int j = 0; j < B.get(i).size(); j++) {
            System.out.print(B.get(i).get(j) + " ");
    }
}

/* The above java code is the same as the code (in C++) below

vector<vector<int> > B = performOps(A);
for (int i = 0; i < B.size(); i++) {
    for (int j = 0; j < B[i].size(); j++) cout<<B[i][j]<<" ";
}
//*/

// What is the output?
// 4 3 2 1 8 7 6 5 12 11 10 9
