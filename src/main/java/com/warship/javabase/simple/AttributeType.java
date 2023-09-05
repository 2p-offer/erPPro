package com.warship.test.javabase.simple;


import java.util.HashMap;
import java.util.Map;

/**
 * 属性枚举，与策划MagicAttr配置表一一对应
 *
 * @author erp
 */
public enum AttributeType {

    // 特殊类型,每个属性需要单独AbstractSpecialAttrLogic处理
    /** 武装 1武装 = 4物理攻击绝对值 + 2物理防御绝对值 */
    ARMS_BASE("armsBase", AttributeNumType.BASE),
    ARMS_PERCENT("armsPercent", AttributeNumType.PERCENT_ADD_UP),
    ARMS_ABSOLUTE("armsAbsolute", AttributeNumType.ABSOLUTE),

    SCIENCE_BASE("scienceBase", AttributeNumType.BASE),
    SCIENCE_PERCENT("sciencePercent", AttributeNumType.PERCENT_ADD_UP),
    SCIENCE_ABSOLUTE("scienceAbsolute", AttributeNumType.ABSOLUTE),

    POWER_BASE("powerBase", AttributeNumType.BASE),
    POWER_PERCENT("powerPercent", AttributeNumType.PERCENT_ADD_UP),
    POWER_ABSOLUTE("powerAbsolute", AttributeNumType.ABSOLUTE),

    // 特殊类型 END

    /** 基础领导力 */
    LEADERSHIP("leadership", AttributeNumType.BASE),


    /** 当前血量 */
    CURR_HP("currHp", AttributeNumType.BASE),
    /** 当前能量 */
    CURR_MP("currMp", AttributeNumType.BASE),

    /** 基础值值血量 */
    HP_BASE("hpBase", AttributeNumType.BASE),
    /** 百分比血量 */
    HP_PERCENT("hpPercent", AttributeNumType.PERCENT_ADD_UP),
    /** 绝对值血量 */
    HP_ABSOLUTE("hpAbsolute", AttributeNumType.ABSOLUTE),


    /** 基础值能量 */
    MP_BASE("mpBase", AttributeNumType.BASE),
    /** 百分比能量 */
    MP_PERCENT("mpPercent", AttributeNumType.PERCENT_ADD_UP),
    /** 绝对值能量 */
    MP_ABSOLUTE("mpAbsolute", AttributeNumType.ABSOLUTE),

    /** 基础值值物理攻击 */
    PHYSICAL_ATTACK_BASE_UP("physicalAttackBaseUp", AttributeNumType.BASE),
    /** 百分比物理攻击A */
    PHYSICAL_ATTACK_PERCENT_UP("physicalAttackPercentUp", AttributeNumType.PERCENT_ADD_UP),
    /** 百分比物理攻击B */
    PHYSICAL_ATTACK_PERCENT_DOWN("physicalAttackPercentDown", AttributeNumType.PERCENT_ADD_DOWN),
    /** 绝对值物理攻击 */
    PHYSICAL_ATTACK_ABSOLUTE_UP("physicalAttackAbsoluteUp", AttributeNumType.ABSOLUTE),

    /** 基础值值元素攻击 */
    ELEMENT_ATTACK_BASE_UP("elementAttackBaseUp", AttributeNumType.BASE),
    /** 百分比元素攻击A */
    ELEMENT_ATTACK_PERCENT_UP("elementAttackPercentUp", AttributeNumType.PERCENT_ADD_UP),
    /** 百分比元素攻击B */
    ELEMENT_ATTACK_PERCENT_DOWN("elementAttackPercentDown", AttributeNumType.PERCENT_ADD_DOWN),
    /** 绝对值元素攻击 */
    ELEMENT_ATTACK_ABSOLUTE_UP("elementAttackAbsoluteUp", AttributeNumType.ABSOLUTE),

    /** 物理防御 */
    PHYSICAL_DEFENSE_BASE_UP("physicalDefenseBaseUp", AttributeNumType.BASE),
    PHYSICAL_DEFENSE_PERCENT_UP("physicalDefensePercentUp", AttributeNumType.PERCENT_ADD_UP),
    PHYSICAL_DEFENSE_PERCENT_DOWN("physicalDefensePercentDown", AttributeNumType.PERCENT_ADD_DOWN),
    PHYSICAL_DEFENSE_ABSOLUTE_UP("physicalDefenseAbsoluteUp", AttributeNumType.ABSOLUTE),

    /** 元素防御 */
    ELEMENT_DEFENSE_BASE_UP("elementDefenseBaseUp", AttributeNumType.BASE),
    ELEMENT_DEFENSE_PERCENT_UP("elementDefensePercentUp", AttributeNumType.PERCENT_ADD_UP),
    ELEMENT_DEFENSE_PERCENT_DOWN("elementDefensePercentDown", AttributeNumType.PERCENT_ADD_DOWN),
    ELEMENT_DEFENSE_ABSOLUTE_UP("elementDefenseAbsoluteUp", AttributeNumType.ABSOLUTE),

    /** 暴击 */
    CRIT_BASE("critBase", AttributeNumType.BASE),
    CRIT_PERCENT("critPercent", AttributeNumType.PERCENT_ADD_UP),
    CRIT_ABSOLUTE("critAbsolute", AttributeNumType.ABSOLUTE),

    /** 抗暴 */
    CRIT_BASE_RESISTANCE("critBaseResistance", AttributeNumType.BASE),
    CRIT_PERCENT_RESISTANCE("critPercentResistance", AttributeNumType.PERCENT_ADD_UP),
    CRIT_ABSOLUTE_RESISTANCE("critAbsoluteResistance", AttributeNumType.ABSOLUTE),

    /** 暴击倍率 */
    CRIT_MAGNIFICATION("critMagnification", AttributeNumType.ABSOLUTE),
    /** 暴击增伤 */
    CRITICAL_INCREASES_DAMAGE("criticalIncreasesDamage", AttributeNumType.ABSOLUTE),
    /** 暴击格挡 */
    CRITICAL_BLOCK("criticalBlock", AttributeNumType.ABSOLUTE),

    /** 物理命中 */
    PHYSICAL_HIT_BASE_UP("physicalHitBaseUp", AttributeNumType.BASE),
    PHYSICAL_HIT_PERCENT_UP("physicalHitPercentUp", AttributeNumType.PERCENT_ADD_UP),
    PHYSICAL_HIT_PERCENT_DOWN("physicalHitPercentDown", AttributeNumType.PERCENT_ADD_DOWN),
    PHYSICAL_HIT_ABSOLUTE_UP("physicalHitAbsoluteUp", AttributeNumType.ABSOLUTE),

    /** 元素命中 */
    ELEMENT_HIT_BASE_UP("elementHitBaseUp", AttributeNumType.BASE),
    ELEMENT_HIT_PERCENT_UP("elementHitPercentUp", AttributeNumType.PERCENT_ADD_UP),
    ELEMENT_HIT_PERCENT_DOWN("elementHitPercentDown", AttributeNumType.PERCENT_ADD_DOWN),
    ELEMENT_HIT_ABSOLUTE_UP("elementHitAbsoluteUp", AttributeNumType.ABSOLUTE),

    /** 物理闪避 */
    PHYSICAL_DODGE_BASE_UP("physicalDodgeBaseUp", AttributeNumType.BASE),
    PHYSICAL_DODGE_PERCENT_UP("physicalDodgePercentUp", AttributeNumType.PERCENT_ADD_UP),
    PHYSICAL_DODGE_PERCENT_DOWN("physicalDodgePercentDown", AttributeNumType.PERCENT_ADD_DOWN),
    PHYSICAL_DODGE_ABSOLUTE_UP("physicalDodgeAbsoluteUp", AttributeNumType.ABSOLUTE),

    /** 元素闪避 */
    ELEMENT_DODGE_BASE_UP("elementDodgeBaseUp", AttributeNumType.BASE),
    ELEMENT_DODGE_PERCENT_UP("elementDodgePercentUp", AttributeNumType.PERCENT_ADD_UP),
    ELEMENT_DODGE_PERCENT_DOWN("elementDodgePercentDown", AttributeNumType.PERCENT_ADD_DOWN),
    ELEMENT_DODGE_ABSOLUTE_UP("elementDodgeAbsoluteUp", AttributeNumType.ABSOLUTE),

    /** 物理破防 */
    PHYSICAL_PENETRATE_BASE_UP("physicalPenetrateBaseUp", AttributeNumType.BASE),
    PHYSICAL_PENETRATE_PERCENT_UP("physicalPenetratePercentUp", AttributeNumType.PERCENT_ADD_UP),
    PHYSICAL_PENETRATE_ABSOLUTE_UP("physicalPenetrateAbsoluteUp", AttributeNumType.ABSOLUTE),

    /** 元素破防 */
    ELEMENT_PENETRATE_BASE_UP("elementPenetrateBaseUp", AttributeNumType.BASE),
    ELEMENT_PENETRATE_PERCENT_UP("elementPenetratePercentUp", AttributeNumType.PERCENT_ADD_UP),
    ELEMENT_PENETRATE_ABSOLUTE_UP("elementPenetrateAbsoluteUp", AttributeNumType.ABSOLUTE),

    /** 物理格挡 */
    PHYSICAL_BLOCK_BASE_UP("physicalBlockBaseUp", AttributeNumType.BASE),
    PHYSICAL_BLOCK_PERCENT_UP("physicalBlockPercentUp", AttributeNumType.PERCENT_ADD_UP),
    PHYSICAL_BLOCK_ABSOLUTE_UP("physicalBlockAbsoluteUp", AttributeNumType.ABSOLUTE),

    /** 元素格挡 */
    ELEMENT_BLOCK_BASE_UP("elementBlockBaseUp", AttributeNumType.BASE),
    ELEMENT_BLOCK_PERCENT_UP("elementBlockPercentUp", AttributeNumType.PERCENT_ADD_UP),
    ELEMENT_BLOCK_ABSOLUTE_UP("elementBlockAbsoluteUp", AttributeNumType.ABSOLUTE),

    /** 攻击怪物伤害加成 */
   // ATTACK_MONSTER_DAMAGE_ADD_BASE("attackMonsterDamageAddBase", AttributeNumType.BASE),
    /** 攻击城市技能伤害 */
    //ATTACK_CITY_SKILL_DAMAGE_ADD_BASE("attackCitySkillDamageAddBase", AttributeNumType.BASE),
    /** 攻击城市武器伤害 */
    //ATTACK_CITY_WEAPON_DAMAGE_ADD_BASE("attackCityWeaponDamageAddBase", AttributeNumType.BASE),

    /** 受到技能伤害减免 */
    //REDUCED_DAMAGE_BY_SKILL_ADD_BASE("reducedDamageBySkillAddBase", AttributeNumType.BASE),
    /** 受到武器伤害减免 */
    //REDUCED_DAMAGE_BY_WEAPON_ADD_BASE("reducedDamageByWeaponAddBase", AttributeNumType.BASE),

    /** 护盾 */
    SHIELDMP("shieldMp", AttributeNumType.BASE),
    /** 血盾 */
    SHIELDHP("shieldHp", AttributeNumType.BASE),
    /** 致盲 */
    BLIND("blind", AttributeNumType.BASE),
    /** 免疫 */
    IMMUNE("immune", AttributeNumType.BASE),
    /** 诅咒 */
    CURSE("curse", AttributeNumType.BASE),
    /** 中毒 */
    POISON("poison", AttributeNumType.BASE),
    /** 沉默 */
    SILENCE("silence", AttributeNumType.BASE),

    /** 定身 */
    HOLD("hold", AttributeNumType.BASE),
    /** 冰冻 */
    FROST("frost", AttributeNumType.BASE),
    /** 嘲讽 */
    RIDICULE("ridicule", AttributeNumType.BASE),
    /** 幻象 */
    VISION("vision", AttributeNumType.BASE),
    /** 人阶控制效果抵抗 */
   // PRIMARY_CONTROL_RESIST("primaryControlResist", AttributeNumType.BASE),

    /** 回复生命 */
    HP_RECOVERY("hpRecovery", AttributeNumType.BASE),
    /** 回复能量 */
    MP_RECOVERY("mpRecovery", AttributeNumType.BASE),


    /** 基础值值加速 */
    SPEED_BASE("speedBase", AttributeNumType.BASE),
    /** 百分比加速A */
    SPEED_PERCENT_UP("speedPercentUp", AttributeNumType.PERCENT_ADD_UP),
    /** 百分比加速B */
    SPEED_PERCENT_DOWN("speedPercentDown", AttributeNumType.PERCENT_ADD_DOWN),
    /** 绝对值加速 */
    SPEED_ABSOLUTE("speedAbsolute", AttributeNumType.ABSOLUTE),

    /** 训练爆发次数 */
    TRAINING_BURST_BASE("trainingBurstBase", AttributeNumType.BASE),
    /** 畅饮次数 */
    DRINK_FREELY_BASE("drinkFreelyBase", AttributeNumType.BASE),

    /** 当前书籍基础属性提升百分比 */
    CURRENT_BOOK_BASIC_PROPERTIES_PERCENT("currentBookBasicPropertiesPercent", AttributeNumType.PERCENT_ADD_UP),

    /** 元素伤害百分比 */
    ELEMENT_INJURY_BASE("elementInjuryBase", AttributeNumType.BASE),
    /** 暴击倍率抗性 */
    CRIT_MAGNIFICATION_RESISTANCE("critMagnificationResistance", AttributeNumType.BASE),
    /** 脱战每秒生命恢复百分比 */
    QUIT_HP_RECOVERY("quitHpRecovery", AttributeNumType.BASE),
    /** 脱战每秒能量恢复百分比 */
    QUIT_MP_RECOVERY("quitMpRecovery", AttributeNumType.BASE),
    /** 杀戮值固定值 */
    KILL_VALUE("killValue", AttributeNumType.BASE),
    /** 当前装备基础属性加成百分比 */
    CURRENT_EQUIP_BASIC_PROPERTIES_PERCENT("currentEquipBasicPropertiesPercent", AttributeNumType.PERCENT_ADD_UP),
    /** 当前藏品基础属性加成百分比 */
    CURRENT_COLLECTION_PASSIVE_ATTRIBUTE_PERCENT("currentCollectionPassiveAttributePercent", AttributeNumType.PERCENT_ADD_UP),

    /** 人阶控制效果时间抵抗 */
    PRIMARY_CONTROL_TIME_RESIST("primaryControlTimeResist",AttributeNumType.BASE),
    /** 控制概率强化 */
    CONTROL_PROBABILITY("controlProbability",AttributeNumType.BASE),
    /** 控制概率抗性 */
    CONTROL_PROBABILITY_RESISTBASE("controlProbabilityResistBase",AttributeNumType.BASE),
    /** 控制概率百分比抵抗 */
    CONTROL_PROBABILITY_REDUCTION("controlProbabilityReduction",AttributeNumType.BASE),
    /** 固定值控制时间 */
    CONTROL_TIME_BASE("controlTimeBase",AttributeNumType.BASE),
    /** 百分比控制时间 */
    CONTROL_TIME_PERCENT("controlTimePercent",AttributeNumType.PERCENT_ADD_UP),
    /** 绝对值控制时间强化 */
    CONTROL_TIME_ENHANCEMENT("controlTimeEnhancement",AttributeNumType.ABSOLUTE),
    /** 固定值控制时间抗性 */
    CONTROL_TIME_RESIST_BASE("controlTimeResistBase",AttributeNumType.BASE),
    /** 控制时间百分比抵抗  */
    CONTROL_TIME_REDUCTION("controlTimeReduction",AttributeNumType.PERCENT_ADD_UP),

    /** 血量回复效果衰减  */
    HP_RECOVERY_EFFECT_ATTENUATION("hpRecoveryEffectAttenuation",AttributeNumType.BASE),
    /** 能量回复效果衰减  */
    MP_RECOVERY_EFFECT_ATTENUATION("mpRecoveryEffectAttenuation",AttributeNumType.BASE),
    /** 技能全状态持续时间提升固定值  */
    SKILL_EFFECT_TIME_BASE_UP("SkillEffectTimeBaseUp",AttributeNumType.BASE),
    /** 技能全状态持续时间提升百分比  */
    SKILL_EFFECT_TIME_PERCENT_UP("SkillEffectTimePercentUp",AttributeNumType.PERCENT_ADD_UP),
    /** 攻击怪物伤害提高百分比  */
    ATTACK_MONSTER_DAMAGE_ADD_PERCENT("attackMonsterDamageAddPercent",AttributeNumType.BASE),
    /** 受到怪物伤害减免 */
    REDUCED_DAMAGE_BY_MONSTER_ADD_BASE("reducedDamageByMonsterAddBase", AttributeNumType.BASE),

    /** 技能物理伤害提升固定值  */
    ARMS_SKILL_DAMAGE_PHYSICAL_BASE ("ArmsSkillDamagePhysicalBase",AttributeNumType.BASE),
    /** 技能物理伤害倍率提升  */
    ARMS_SKILL_DAMAGE_PHYSICAL_PERCENT("ArmsSkillDamagePhysicalPercent",AttributeNumType.PERCENT_ADD_UP),
    /** 技能元素伤害提升固定值  */
    ARMS_SKILL_DAMAGE_ELEMENT_BASE("ArmsSkillDamageElementBase",AttributeNumType.BASE),
    /** 技能元素伤害倍率提升  */
    ARMS_SKILL_DAMAGE_ELEMENT_PERCENT("ArmsSkillDamageElementPercent",AttributeNumType.PERCENT_ADD_UP),
    /** 技能护盾增加固定值  */
    ARMS_SKILL_SHIELD_BASE("ArmsSkillShieldBase",AttributeNumType.BASE),
    /** 技能护盾增加倍率  */
    ARMS_SKILL_SHIELD_PERCENT("ArmsSkillShieldPercent",AttributeNumType.PERCENT_ADD_UP),
    /** 技能释放速率提高百分比  */
    ARMS_SKILL_RELEASE_SPEED_PERCENT("ArmsSkillReleaseSpeedPercent",AttributeNumType.BASE),
    /** 攻击城市技能伤害提高百分比  */
    ATTACK_CITY_SKILL_DAMAGE_ADD_PERCENT("attackCitySkillDamageAddPercent",AttributeNumType.BASE),
    /** 受到城市技能伤害减少百分比  */
    REDUCED_DAMAGE_BY_CITY_SKILL_PERCENT_DOWN("reducedDamageByCitySkillPercentDown",AttributeNumType.BASE),
    /** 攻击城市武器伤害提高百分比  */
    ATTACK_CITY_WEAPON_DAMAGE_PERCENT_UP("attackCityWeaponDamagePercentUp",AttributeNumType.BASE),
    /** 受到城市武器伤害减少百分比  */
    REDUCED_DAMAGE_BY_WEAPON_PERCENT_DOWN("reducedDamageByWeaponPercentDown",AttributeNumType.BASE),
    /** 宠物服用经验饮品效果提升百分比  */
    PETS_EXP_DRUG_USE_EFFECT_PERCENT_UP("petsExpDrugUseEffectPercentUp",AttributeNumType.BASE),
    /** 所有宠物资质上限提升固定值  */
    PETS_WHOLE_POTENTIAL_BASE_UP("petsWholePotentialBaseUp",AttributeNumType.BASE),
    /** 训练爆发效果增加百分比  */
    TRAINING_BURST_EFFECT_PERCENT_UP("trainingBurstEffectPercentUp",AttributeNumType.BASE),
    /** 训练爆发次数增加固定值  */
    TRAINING_BURST_USE_NUMBER("trainingBurstUseNumber",AttributeNumType.BASE),
    /** 训练爆发次数一键开启  */
    TRAINING_BURST_BATCH_USE("trainingBurstBatchUse",AttributeNumType.BASE),
    /** 猎场挂机掉落金币加成百分比  */
    HUNTING_GROUND_GOLD_COINS_PRODUCE_PERCENT_UP("huntingGroundGoldCoinsProducePercentUp",AttributeNumType.BASE),
    /** 经验饮品增加服用效果百分比  */
    EXP_DRUG_USE_EFFECT_PERCENT_UP("expDrugUseEffectPercentUp",AttributeNumType.BASE),
    /** 每日经验饮品使用次数增加固定值  */
    DAILY_EXP_DRUG_USE_NUMBER("dailyExpDrugUseNumber",AttributeNumType.BASE),
    /**  训练默认经验加成百分比 */
    TRAINING_EXP_DEFAULT_PERCENT_UP("trainingExpDefaultPercentUp",AttributeNumType.BASE),
    /** 训练领悟效率加成百分比  */
    TRAINING_EXP_UNDERSTANDING_PERCENT_UP("trainingExpUnderstandingPercentUp",AttributeNumType.BASE),

    /** 受到物理伤害百分比 TODO 待实现 */
    SUFFER_PHYSICAL_INJURY_BASE("sufferPhysicalInjuryBase", AttributeNumType.BASE),
    /** 受到元素伤害百分比 TODO 待实现 */
    SUFFER_ELEMENT_INJURY_BASE("sufferElementInjuryBase", AttributeNumType.BASE),
    /** 物理伤害百分比 TODO 待实现 */
    PHYSICAL_INJURY_BASE("physicalInjuryBase", AttributeNumType.BASE),
    /** 引魔香刷怪效果 */
    EFFECT_BRUSH_MONSTER("effectbrushMonster", AttributeNumType.BASE),
    /** 红名值 */
    RED_VALUE("killValue", AttributeNumType.BASE),
    /** 恶名惩罚 */
    NOTORIETY_PUNISHMENT("notorietyPunishment", AttributeNumType.BASE),


    //...
    ;

    /** typeStr : attrTypeEnum */
    private static final Map<String, AttributeType> ATTRIBUTE_TYPE_MAP = new HashMap<>();


    static {
        for (AttributeType attributeType : values()) {
            ATTRIBUTE_TYPE_MAP.put(attributeType.type, attributeType);
        }
    }

    /** 属性类型 */
    private final String type;

    /** 值类型 */
    private final AttributeNumType numType;


    AttributeType(String type, AttributeNumType numType) {
        this.type = type;
        this.numType = numType;
    }


    public String getType() {
        return type;
    }

    public AttributeNumType getNumType() {
        return numType;
    }
}
