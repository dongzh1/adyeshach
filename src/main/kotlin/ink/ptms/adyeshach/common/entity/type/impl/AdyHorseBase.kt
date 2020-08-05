package ink.ptms.adyeshach.common.entity.type.impl

import ink.ptms.adyeshach.common.entity.type.EntityTypes
import ink.ptms.adyeshach.api.nms.NMS
import org.bukkit.entity.Player

/**
 * @Author sky
 * @Since 2020-08-04 18:28
 */
abstract class AdyHorseBase(owner: Player, entityTypes: EntityTypes) : AdyEntityAgeable(owner, entityTypes) {

    init {
        /**
         * 1.13  Index->13, 0x80 = UnUsed
         * 1.12 Index->13
         *      isSaddled 后 + hasChest, bitMask 依次类推, 最后一个 0x80
         * 1.9 Index->12, 同 1.12
         *     Index: 13 VarInt	Variant
         *     Index: 14 VarInt	Color & Style
         *     Index: 15 OptUUID	Owner
         *     Index: 16 VarInt	Armor
         */
        registerMetaByteMask(16, "isTamed", 0x02)
        registerMetaByteMask(16, "isSaddled", 0x04)
        registerMetaByteMask(16, "hasBred", 0x08)
        registerMetaByteMask(16, "isEating", 0x10)
        registerMetaByteMask(16, "isRearing", 0x20)
        registerMetaByteMask(16, "isMouthOpen", 0x40)
    }

    fun setTamed(value: Boolean) {
        setMetadata("isTamed", value)
    }

    fun isTamed(): Boolean {
        return getMetadata("isTamed")
    }

    fun setSaddled(value: Boolean) {
        setMetadata("isSaddled", value)
    }

    fun isSaddled(): Boolean {
        return getMetadata("isSaddled")
    }

    fun setHasBred(value: Boolean) {
        setMetadata("hasBred", value)
    }

    fun isHasBred(): Boolean {
        return getMetadata("hasBred")
    }

    fun setEating(value: Boolean) {
        setMetadata("isEating", value)
    }

    fun isEating(): Boolean {
        return getMetadata("isEating")
    }

    fun setRearing(value: Boolean) {
        setMetadata("isRearing", value)
    }

    fun isRearing(): Boolean {
        return getMetadata("isRearing")
    }

    fun setMouthOpen(value: Boolean) {
        setMetadata("isMouthOpen", value)
    }

    fun isMouthOpen(): Boolean {
        return getMetadata("isMouthOpen")
    }
}