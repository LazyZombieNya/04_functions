fun main(){

    println("Был(а) "+agoToText(50));
    println("Был(а) "+agoToText(200));
    println("Был(а) "+agoToText(800));
    println("Был(а) "+agoToText(50000));
    println("Был(а) "+agoToText(80000));
    println("Был(а) "+agoToText(100000));
    println("Был(а) "+agoToText(200000));
    println("Был(а) "+agoToText(500000));

    println("Комиссия Maestro: "+commissionPrice(500,300,"Maestro"));
    println("Комиссия Maestro: "+commissionPrice(3000,80000,"Maestro"));
    println("Комиссия VK Pay: "+commissionPrice(90000,700,"VK Pay"));
    println("Комиссия Visa: "+commissionPrice(3000,80000,"Visa"));
    println("Комиссия Мир: "+commissionPrice(500,300,"Мир"));


}
fun agoToText(time:Int):String{
    return when (time){
        in 0..60->"Только что"
        in 61..60*60->minutesInText(time/60)
        in 60*60+1.. 24 * 60 * 60->hoursInText(time/(60*60))
        in 86401.. 172800->"Вчера"
        in 172801.. 259200->"Позавчера"
        else->"Давно"
    }
}
fun minutesInText(time: Int):String{
    return when (time) {
        in 11..19 -> "$time минут назад"
        else -> when (time % 10) {
            2, 3, 4 -> "$time минуты назад";
            1 -> "$time минуту назад";
            else -> "$time минут назад";
        }
    }
}
fun hoursInText(time: Int):String{
    return when (time) {
        in 11..19 -> "$time часов назад"
        else -> return when (time % 10) {
            2, 3, 4 -> "$time часа назад";
            1 -> "$time час назад";
            else -> "$time часов назад";
        }
    }
}

fun commissionPrice(transfer: Int,sumPreviousTransfer: Int,typeCard:String,):Int{
    return when (typeCard){
        "Maestrocard","Maestro"-> when{
            (transfer > 150000) || (transfer+sumPreviousTransfer > 600000) ->-1
            sumPreviousTransfer+transfer<75000->0
            else-> (transfer*0.006).toInt()+20
        }
        "VK Pay"->when{
            (transfer > 15000) || (transfer+sumPreviousTransfer > 40000) ->-1
            else -> 0
        }
        else -> when{
            (transfer > 150000) || (transfer+sumPreviousTransfer > 600000) ->-1
            ((transfer*0.0075).toInt()<35)->35
            else-> (transfer*0.0075).toInt()
        }
    }
}