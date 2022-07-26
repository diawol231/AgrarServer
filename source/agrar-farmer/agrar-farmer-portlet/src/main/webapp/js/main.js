function capitalizeFirstLetter(str) {
    var splitStr = str.toLowerCase().split(' ');
    for (var i = 0; i < splitStr.length; i++) {
        splitStr[i] = splitStr[i].charAt(0).toUpperCase() + splitStr[i].substring(1);
    }
    var newstr = splitStr.join(' ');
    var splitStr1 = newstr.split('-');
    for (var i = 0; i < splitStr1.length; i++) {
        splitStr1[i] = splitStr1[i].charAt(0).toUpperCase() + splitStr1[i].substring(1);
    }
    return splitStr1.join('-');
}