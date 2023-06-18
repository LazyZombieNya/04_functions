import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun agoToText_hours21() {
        val time:Int = 78000

        val result = agoToText(time)

        assertEquals("21 час назад",result)
    }
    @Test
    fun agoToText_hours20() {
        val time:Int = 75000

        val result = agoToText(time)

        assertEquals("20 часов назад",result)
    }

    @Test
    fun agoToText_hours22() {
        val time:Int = 80000

        val result = agoToText(time)

        assertEquals("22 часа назад",result)
    }

    @Test
    fun agoToText_minutes10() {
        val time:Int = 600

        val result = agoToText(time)

        assertEquals("10 минут назад",result)
    }
    @Test
    fun agoToText_minutes21() {
        val time:Int = 1300

        val result = agoToText(time)

        assertEquals("21 минуту назад",result)
    }
    @Test
    fun agoToText_minutes23() {
        val time:Int = 1400

        val result = agoToText(time)

        assertEquals("23 минуты назад",result)
    }


    @Test
    fun agoToText_days() {
        val time:Int = 100000

        val result = agoToText(time)

        assertEquals("Вчера",result)
    }
    @Test
    fun agoToText_moreDays() {
        val time:Int = 800000

        val result = agoToText(time)

        assertEquals("Давно",result)
    }


    @Test
    fun commissionPrice_forMaestroLimitMoney1() {
        val transfer: Int = 5000
        val sumPreviousTransfer: Int = 3000000
        val typeCard:String = "Maestro"

        val result = commissionPrice(transfer,sumPreviousTransfer,typeCard)

        assertEquals(-1,result)
    }
    @Test
    fun commissionPrice_forMaestroLimitMoney2() {
        val transfer: Int = 50000000
        val sumPreviousTransfer: Int = 3000
        val typeCard:String = "Maestro"

        val result = commissionPrice(transfer,sumPreviousTransfer,typeCard)

        assertEquals(-1,result)
    }
    @Test
    fun commissionPrice_forMaestroLimitMoney3() {
        val transfer: Int = 50000000
        val sumPreviousTransfer: Int = 50000000
        val typeCard:String = "Maestro"

        val result = commissionPrice(transfer,sumPreviousTransfer,typeCard)

        assertEquals(-1,result)
    }

    @Test
    fun commissionPrice_forMaestroMoreMoney() {
        val transfer: Int = 50000
        val sumPreviousTransfer: Int = 30000
        val typeCard:String = "Maestro"

        val result = commissionPrice(transfer,sumPreviousTransfer,typeCard)

        assertEquals(320,result)
    }

    @Test
    fun commissionPrice_forMaestroSmallMoney() {
        val transfer: Int = 500
        val sumPreviousTransfer: Int = 300
        val typeCard:String = "Maestro"

        val result = commissionPrice(transfer,sumPreviousTransfer,typeCard)

        assertEquals(0,result)
    }

    @Test
    fun commissionPrice_forVkpayLimitMoney1() {
        val transfer: Int = 90000
        val sumPreviousTransfer: Int = 700
        val typeCard:String = "VK Pay"

        val result = commissionPrice(transfer,sumPreviousTransfer,typeCard)

        assertEquals(-1,result)
    }
    @Test
    fun commissionPrice_forVkpayLimitMoney2() {
        val transfer: Int = 900
        val sumPreviousTransfer: Int = 700000
        val typeCard:String = "VK Pay"

        val result = commissionPrice(transfer,sumPreviousTransfer,typeCard)

        assertEquals(-1,result)
    }
    @Test
    fun commissionPrice_forVkpayLimitMoney3() {
        val transfer: Int = 700000
        val sumPreviousTransfer: Int = 700000
        val typeCard:String = "VK Pay"

        val result = commissionPrice(transfer,sumPreviousTransfer,typeCard)

        assertEquals(-1,result)
    }

    @Test
    fun commissionPrice_forVkpaySmallMoney() {
        val transfer: Int = 3000
        val sumPreviousTransfer: Int = 700
        val typeCard:String = "VK Pay"

        val result = commissionPrice(transfer,sumPreviousTransfer,typeCard)

        assertEquals(0,result)
    }
    @Test
    fun commissionPrice_forVkpaySmallMoney2() {
        val transfer: Int = 300
        val sumPreviousTransfer: Int = 700
        val typeCard:String = "VK Pay"

        val result = commissionPrice(transfer,sumPreviousTransfer,typeCard)

        assertEquals(0,result)
    }

    @Test
    fun commissionPrice_forOtherCardMoreMoney() {
        val transfer: Int = 30000
        val sumPreviousTransfer: Int = 80000
        val typeCard:String = "Visa"

        val result = commissionPrice(transfer,sumPreviousTransfer,typeCard)

        assertEquals(225,result)
    }

    @Test
    fun commissionPrice_forOtherCardLimitMoney1() {
        val transfer: Int = 300000
        val sumPreviousTransfer: Int = 8000
        val typeCard:String = "Visa"

        val result = commissionPrice(transfer,sumPreviousTransfer,typeCard)

        assertEquals(-1,result)
    }
    @Test
    fun commissionPrice_forOtherCardLimitMoney2() {
        val transfer: Int = 3000
        val sumPreviousTransfer: Int = 800000
        val typeCard:String = "Visa"

        val result = commissionPrice(transfer,sumPreviousTransfer,typeCard)

        assertEquals(-1,result)
    }
    @Test
    fun commissionPrice_forOtherCardLimitMoney3() {
        val transfer: Int = 800000
        val sumPreviousTransfer: Int = 800000
        val typeCard:String = "Visa"

        val result = commissionPrice(transfer,sumPreviousTransfer,typeCard)

        assertEquals(-1,result)
    }

    @Test
    fun commissionPrice_forOtherCardSmallMoney() {
        val transfer: Int = 500
        val sumPreviousTransfer: Int = 3000
        val typeCard:String = "Other"

        val result = commissionPrice(transfer,sumPreviousTransfer,typeCard)

        assertEquals(35,result)
    }
}