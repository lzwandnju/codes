pulbic void bubbleSort(int[]arr){
	if(arr==null||arr.length==0){
		return;
	}
	for(int i=0;i<arr.length-1;i++){
		for(int j=0;j<arr.length-i-1;j++){
			if(arr[j+1]<arr[j]){
				int temp=arr[j+1];
				arr[j+1]=arr[j];
				arr[j]=temp;
			}
		}
	}
}

public void selectSort(int []arr){
	if(arr==null||arr.length==0){
		return ;
	}
	for(int i=0;i<arr.length-1;i++){
		for(int j=i+1;j<arr.length;j++){
			if(arr[j]<arr[i]){
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
	}
}

public void insertSort(int []arr){
	if(arr==null||arr.length==0){
		return ;
	}
	for(int i=1;i<arr.length;i++){
		int value=arr[i];
		int index=i;
		for(int j=i-1;j>=0;j--){
			if(arr[j]>value){
				arr[j+1]=arr[j];
				index-=1;
			}else{
				break;
			}
		}
		arr[index]=value;
	}
}

public void quickSort(int[]arr,int low,int high){
	int l=low;
	int h=high;
	int pivot=arr[low];
	while(l<h){
		while(pivot<arr[h] && l<h){
			h--;
		}
		if(l<h){
			int temp=arr[l];
			arr[l]=arr[h];
			arr[h]=temp;
			l++;
		}
		while(pivot>arr[l] && l<h){
			l++;
		}
		if(l<h){
			int temp=arr[l];
			arr[l]=arr[h];
			arr[h]=temp;
			h++;
		}
	}
	if(l<high){
		quickSort(arr,l+1,high);
	}
	if(l>low){
		quickSort(arr,low,l-1);
	}
}

pulbic int binarySearch(int []arr,int k){
	int low=0;
	int high=arr.length-1;
	while(low<=high){
		int middle=low+(high-low)/2;
		if(arr[middle]>k){
			high=middle-1;
		}else if(arr[middle]<k){
			low=middle-1;
		}else{
			return middle;
		}
	}
	return -1;
}

pulbic int binarySearch(int[]arr,int k,int low,int high){
	if(k<arr[low] || k>arr[high] ||low>high){
		return -1;
	}
	int middle=low+(high-low)/2;
	if(arr[middle]>k){
		binarySearch(arr,k,middle+1,high);
	}else if(arr[middle]<k){
		binarySearch(arr,k,low,middle-1);
	}else{
		return middle;
	}
}
























































































