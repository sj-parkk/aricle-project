function nullChecker(arr){
    for(let key in arr){
        let value = arr[key];
        if(!value){
            alert(key + '의 값을 입력해주세요');
            return false;
        }else{
            return true;
        }
    }
}