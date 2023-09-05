package com.warship.test.javabase.simple;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 属性类型【真正的调用计算属性类型】
 *
 * @author erp
 */
public enum AttributeTotalType {


    // 特殊类型START,每个属性需要单独AbstractSpecialAttrLogic处理
    /** 武装 1武装 = 4物理攻击绝对值 + 2物理防御绝对值 */
    ARMS("arms", AttributeType.ARMS_BASE, AttributeType.ARMS_PERCENT, null, null, AttributeType.ARMS_ABSOLUTE, true, false),
    /** 科研 */
    SCIENCE("science", AttributeType.SCIENCE_BASE, AttributeType.SCIENCE_PERCENT, null, null, AttributeType.SCIENCE_ABSOLUTE, true, false),
    /** 动力 */
    POWER("power", AttributeType.POWER_BASE, AttributeType.POWER_PERCENT, null, null, AttributeType.POWER_ABSOLUTE, true, false),

    // 特殊类型END

    /** 基础领导力 */
    LEADERSHIP("leadership", AttributeType.LEADERSHIP, null, null, null, null, false, false),

    /** 当前血量 */
    CURR_HP("currHp", AttributeType.CURR_HP, null, null, null, null, false, false),
    /** 当前能量 */
    CURR_MP("currMp", AttributeType.CURR_MP, null, null, null, null, false, false),
    /** 血量 */
    HP("hp", AttributeType.HP_BASE, AttributeType.HP_PERCENT, null, null, AttributeType.HP_ABSOLUTE, false, false),
    /** 能量 */
    MP("mp", AttributeType.MP_BASE, AttributeType.MP_PERCENT, null, null, AttributeType.MP_ABSOLUTE, false, false),
    /** 物理攻击 */
    PHYSICAL_ATTACK("physicalAttack", AttributeType.PHYSICAL_ATTACK_BASE_UP, AttributeType.PHYSICAL_ATTACK_PERCENT_UP, AttributeType.PHYSICAL_ATTACK_PERCENT_DOWN, null, AttributeType.PHYSICAL_ATTACK_ABSOLUTE_UP, false, false),
    /** 元素攻击 */
    ELEMENT_ATTACK("elementAttack", AttributeType.ELEMENT_ATTACK_BASE_UP, AttributeType.ELEMENT_ATTACK_PERCENT_UP, AttributeType.ELEMENT_ATTACK_PERCENT_DOWN, null, AttributeType.ELEMENT_ATTACK_ABSOLUTE_UP, false, false),
    /** 物理防御 */
    PHYSICAL_DEFENSE("physicalDefense", AttributeType.PHYSICAL_DEFENSE_BASE_UP, AttributeType.PHYSICAL_DEFENSE_PERCENT_UP, AttributeType.PHYSICAL_DEFENSE_PERCENT_DOWN, null, AttributeType.PHYSICAL_DEFENSE_ABSOLUTE_UP, false, false),
    /** 元素防御 */
    ELEMENT_DEFENSE("elementDefense", AttributeType.ELEMENT_DEFENSE_BASE_UP, AttributeType.ELEMENT_DEFENSE_PERCENT_UP, AttributeType.ELEMENT_DEFENSE_PERCENT_DOWN, null, AttributeType.ELEMENT_DEFENSE_ABSOLUTE_UP, false, false),
    /** 暴击 */
    CRIT("crit", AttributeType.CRIT_BASE, AttributeType.CRIT_PERCENT, null, null, AttributeType.CRIT_ABSOLUTE, false, false),
    /** 抗暴 */
    CRIT_RESISTANCE("critResistance", AttributeType.CRIT_BASE_RESISTANCE, AttributeType.CRIT_PERCENT_RESISTANCE, null, null, AttributeType.CRIT_ABSOLUTE_RESISTANCE, false, false),
    /** 暴击倍率 */
    CRIT_MAGNIFICATION("critMagnification", AttributeType.CRIT_MAGNIFICATION, null, null, null, null, false, false),
    /** 暴击增伤 */
    CRITICAL_INCREASES_DAMAGE("criticalIncreasesDamage", AttributeType.CRITICAL_INCREASES_DAMAGE, null, null, null, null, false, false),
    /** 暴击格挡 */
    CRITICAL_BLOCK("criticalBlock", AttributeType.CRITICAL_BLOCK, null, null, null, null, false, false),
    /** 物理命中 */
    PHYSICAL_HIT("physicalHit", AttributeType.PHYSICAL_HIT_BASE_UP, AttributeType.PHYSICAL_HIT_PERCENT_UP, AttributeType.PHYSICAL_HIT_PERCENT_DOWN, null, AttributeType.PHYSICAL_HIT_ABSOLUTE_UP, false, false),
    /** 元素命中 */
    ELEMENT_HIT("elementHit", AttributeType.ELEMENT_HIT_BASE_UP, AttributeType.ELEMENT_HIT_PERCENT_UP, AttributeType.ELEMENT_HIT_PERCENT_DOWN, null, AttributeType.ELEMENT_HIT_ABSOLUTE_UP, false, false),
    /** 物理闪避 */
    PHYSICAL_DODGE("physicalDodge", AttributeType.PHYSICAL_DODGE_BASE_UP, AttributeType.PHYSICAL_DODGE_PERCENT_UP, AttributeType.PHYSICAL_DODGE_PERCENT_DOWN, null, AttributeType.PHYSICAL_DODGE_ABSOLUTE_UP, false, false),
    /** 元素闪避 */
    ELEMENT_DODGE("elementDodge", AttributeType.ELEMENT_DODGE_BASE_UP, AttributeType.ELEMENT_DODGE_PERCENT_UP, AttributeType.ELEMENT_DODGE_PERCENT_DOWN, null, AttributeType.ELEMENT_DODGE_ABSOLUTE_UP, false, false),
    /** 物理破防 */
    PHYSICAL_PENETRATE("physicalPenetrate", AttributeType.PHYSICAL_PENETRATE_BASE_UP, AttributeType.PHYSICAL_PENETRATE_PERCENT_UP, null, null, AttributeType.PHYSICAL_PENETRATE_ABSOLUTE_UP, false, false),
    /** 元素破防 */
    ELEMENT_PENETRATE("elementPenetrate", AttributeType.ELEMENT_PENETRATE_BASE_UP, AttributeType.ELEMENT_PENETRATE_PERCENT_UP, null, null, AttributeType.ELEMENT_PENETRATE_ABSOLUTE_UP, false, false),
    /** 物理格挡 */
    PHYSICAL_BLOCK("physicalBlock", AttributeType.PHYSICAL_BLOCK_BASE_UP, AttributeType.PHYSICAL_BLOCK_PERCENT_UP, null, null, AttributeType.PHYSICAL_BLOCK_ABSOLUTE_UP, false, false),
    /** 元素格挡 */
    ELEMENT_BLOCK("elementBlock", AttributeType.ELEMENT_BLOCK_BASE_UP, AttributeType.ELEMENT_BLOCK_PERCENT_UP, null, null, AttributeType.ELEMENT_BLOCK_ABSOLUTE_UP, false, false),
    /** 加速 */
    SPEED("speed", AttributeType.SPEED_BASE, AttributeType.SPEED_PERCENT_UP, AttributeType.SPEED_PERCENT_DOWN, null, AttributeType.SPEED_ABSOLUTE, false, false),

    /** 攻击怪物伤害加成 */
    ATTACK_MONSTER_DAMAGE_ADD("attackMonsterDamageAdd", AttributeType.ATTACK_MONSTER_DAMAGE_ADD_PERCENT, null, null, null, null, false, false),
    /** 攻击城市技能伤害 */
    ATTACK_CITY_SKILL_DAMAGE_ADD("attackCitySkillDamageAdd", AttributeType.ATTACK_CITY_SKILL_DAMAGE_ADD_PERCENT, null, null, null, null, false, false),
    /** 攻击城市武器伤害 */
    ATTACK_CITY_WEAPON_DAMAGE_ADD("attackCityWeaponDamageAdd", AttributeType.ATTACK_CITY_WEAPON_DAMAGE_PERCENT_UP, null, null, null, null, false, false),
    /** 受到怪物伤害减免 */
    REDUCED_DAMAGE_BY_MONSTER_ADD("reducedDamageByMonsterAdd", AttributeType.REDUCED_DAMAGE_BY_MONSTER_ADD_BASE, null, null, null, null, false, false),
    /** 受到技能伤害减免 */
    REDUCED_DAMAGE_BY_SKILL_ADD("reducedDamageBySkillAdd", AttributeType.REDUCED_DAMAGE_BY_CITY_SKILL_PERCENT_DOWN, null, null, null, null, false, false),
    /** 受到武器伤害减免 */
    REDUCED_DAMAGE_BY_WEAPON_ADD("reducedDamageByWeaponAdd", AttributeType.REDUCED_DAMAGE_BY_WEAPON_PERCENT_DOWN, null, null, null, null, false, false),

    /** 回复生命 */
    HP_RECOVERY("hpRecovery", AttributeType.HP_RECOVERY, null, null, null, null, false, false),
    /** 回复能量 */
    MP_RECOVERY("mpRecovery", AttributeType.MP_RECOVERY, null, null, null, null, false, false),
    /** 护盾 */
    SHIELDMP("shieldMp", AttributeType.SHIELDMP, null, null, null, null, false, false),
    /** 血盾 */
    SHIELDHP("shieldHp", AttributeType.SHIELDHP, null, null, null, null, false, false),
    /** 致盲 */
    BLIND("blind", AttributeType.BLIND, null, null, null, null, false, false),
    /** 免疫 */
    IMMUNE("immune", AttributeType.IMMUNE, null, null, null, null, false, false),
    /** 诅咒 */
    CURSE("curse", AttributeType.CURSE, null, null, null, null, false, false),
    /** 中毒 */
    POISON("poison", AttributeType.POISON, null, null, null, null, false, false),
    /** 沉默 */
    SILENCE("silence", AttributeType.SILENCE, null, null, null, null, false, false),
    /** 定身 */
    HOLD("hold", AttributeType.HOLD, null, null, null, null, false, false),
    /** 冰冻 */
    FROST("frost", AttributeType.FROST, null, null, null, null, false, false),
    /** 嘲讽 */
    RIDICULE("ridicule", AttributeType.RIDICULE, null, null, null, null, false, false),
    /** 幻象 */
    VISION("vision", AttributeType.VISION, null, null, null, null, false, false),
    /** 人阶控制效果抵抗 */
    PRIMARY_CONTROL_RESIST("primaryControlResist", AttributeType.PRIMARY_CONTROL_TIME_RESIST, null, null, null, null, false, false),
    /** 训练爆发次数提升 */
    TRAINING_BURST("trainingBurst", AttributeType.TRAINING_BURST_BASE, null, null, null, null, false, false),
    /** 畅饮次数 */
    DRINK_FREELY("drinkFreely", AttributeType.DRINK_FREELY_BASE, null, null, null, null, false, false),
    /** 引魔香刷怪效果 */
    EFFECT_BRUSH_MONSTER("effectbrushMonster", AttributeType.EFFECT_BRUSH_MONSTER, null, null, null, null, false, false),
    /** 红名值 */
    RED_VALUE("killValue", AttributeType.RED_VALUE, null, null, null, null, false, false),
    /** 恶名惩罚 */
    NOTORIETY_PUNISHMENT("notorietyPunishment", AttributeType.NOTORIETY_PUNISHMENT, null, null, null, null, false, false),
    /** 血量回复效果衰减 */
    HP_RECOVERY_EFFECT_ATTENUATION("hpRecoveryEffectAttenuation", AttributeType.HP_RECOVERY_EFFECT_ATTENUATION, null, null, null, null, false, false),
    /** 蓝量回复效果衰减 */
    MP_RECOVERY_EFFECT_ATTENUATION("mpRecoveryEffectAttenuation", AttributeType.MP_RECOVERY_EFFECT_ATTENUATION, null, null, null, null, false, false),


    /** 人阶控制效果时间抵抗 */
    PRIMARY_CONTROL_TIME_RESIST("primaryControlTimeResist", null, null, null, null, null, false, false),
    /** 控制概率强化 */
    CONTROL_PROBABILITY("controlProbability", null, null, null, null, null, false, false),
    /** 控制概率抗性 */
    CONTROL_PROBABILITY_RESIST("controlProbabilityResist", AttributeType.CONTROL_PROBABILITY_RESISTBASE, AttributeType.CONTROL_PROBABILITY_REDUCTION, null, null, null, false, false),
    /** 控制时间 */
    CONTROL_TIME("controlTimePercent", AttributeType.CONTROL_TIME_BASE, AttributeType.CONTROL_TIME_ENHANCEMENT, null, null, null, false, false),
    /** 控制时间抗性 */
    CONTROL_TIME_RESIST_BASE("controlTimeResist", AttributeType.CONTROL_TIME_RESIST_BASE, AttributeType.CONTROL_TIME_REDUCTION, null, null, null, false, false),


    /** 技能全状态持续时间提升值 */
    SKILL_EFFECT_TIME("SkillEffectTime", AttributeType.SKILL_EFFECT_TIME_BASE_UP, AttributeType.SKILL_EFFECT_TIME_PERCENT_UP, null, null, null, false, false),
    /** 攻击怪物伤害提高百分比 */
    ATTACK_MONSTER_DAMAGE_ADD_PERCENT("attackMonsterDamageAddPercent", AttributeType.ATTACK_MONSTER_DAMAGE_ADD_PERCENT, null, null, null, null, false, false),

    /** 技能物理伤害提升值 */
    ARMS_SKILL_DAMAGE_PHYSICAL("ArmsSkillDamagePhysical", AttributeType.ARMS_SKILL_DAMAGE_PHYSICAL_BASE, AttributeType.ARMS_SKILL_DAMAGE_PHYSICAL_PERCENT, null, null, null, false, false),
    /** 技能元素伤害提升值 */
    ARMS_SKILL_DAMAGE_ELEMENT("ArmsSkillDamageElement", AttributeType.ARMS_SKILL_DAMAGE_ELEMENT_BASE, AttributeType.ARMS_SKILL_DAMAGE_ELEMENT_PERCENT, null, null, null, false, false),
    /** 技能护盾增加值 */
    ARMS_SKILL_SHIELD("ArmsSkillShield", AttributeType.ARMS_SKILL_SHIELD_BASE, AttributeType.ARMS_SKILL_SHIELD_PERCENT, null, null, null, false, false),
    /** 技能释放速率提高百分比 */
    ARMS_SKILL_RELEASE_SPEED_PERCENT("ArmsSkillReleaseSpeedPercent", AttributeType.ARMS_SKILL_RELEASE_SPEED_PERCENT, null, null, null, null, false, false),
    /** 攻击城市技能伤害提高百分比 */
    ATTACK_CITY_SKILL_DAMAGE_ADD_PERCENT("attackCitySkillDamageAddPercent", AttributeType.ATTACK_CITY_SKILL_DAMAGE_ADD_PERCENT, null, null, null, null, false, false),
    /** 受到城市技能伤害减少百分比 */
    REDUCED_DAMAGE_BY_CITY_SKILL_PERCENT_DOWN("reducedDamageByCitySkillPercentDown", AttributeType.REDUCED_DAMAGE_BY_CITY_SKILL_PERCENT_DOWN, null, null, null, null, false, false),
    /** 攻击城市武器伤害提高百分比 */
    ATTACK_CITY_WEAPON_DAMAGE_PERCENT_UP("attackCityWeaponDamagePercentUp", AttributeType.ATTACK_CITY_WEAPON_DAMAGE_PERCENT_UP, null, null, null, null, false, false),
    /** 受到城市武器伤害减少百分比 */
    REDUCED_DAMAGE_BY_WEAPON_PERCENT_DOWN("reducedDamageByWeaponPercentDown", AttributeType.REDUCED_DAMAGE_BY_WEAPON_PERCENT_DOWN, null, null, null, null, false, false),
    /** 宠物服用经验饮品效果提升百分比 */
    PETS_EXP_DRUG_USE_EFFECT_PERCENT_UP("petsExpDrugUseEffectPercentUp", AttributeType.PETS_EXP_DRUG_USE_EFFECT_PERCENT_UP, null, null, null, null, false, false),
    /** 所有宠物资质上限提升固定值 */
    PETS_WHOLE_POTENTIAL_BASE_UP("petsWholePotentialBaseUp", AttributeType.PETS_WHOLE_POTENTIAL_BASE_UP, null, null, null, null, false, false),
    /** 训练爆发效果增加百分比 */
    TRAINING_BURST_EFFECT_PERCENT_UP("trainingBurstEffectPercentUp", AttributeType.TRAINING_BURST_EFFECT_PERCENT_UP, null, null, null, null, false, false),
    /** 训练爆发次数增加固定值 */
    TRAINING_BURST_USE_NUMBER("trainingBurstUseNumber", AttributeType.TRAINING_BURST_USE_NUMBER, null, null, null, null, false, false),
    /** 训练爆发次数一键开启 */
    TRAINING_BURST_BATCH_USE("trainingBurstBatchUse", AttributeType.TRAINING_BURST_BATCH_USE, null, null, null, null, false, false),
    /** 猎场挂机掉落金币加成百分比 */
    HUNTING_GROUND_GOLD_COINS_PRODUCE_PERCENT_UP("huntingGroundGoldCoinsProducePercentUp", AttributeType.HUNTING_GROUND_GOLD_COINS_PRODUCE_PERCENT_UP, null, null, null, null, false, false),
    /** 经验饮品增加服用效果百分比 */
    EXP_DRUG_USE_EFFECT_PERCENT_UP("expDrugUseEffectPercentUp", AttributeType.EXP_DRUG_USE_EFFECT_PERCENT_UP, null, null, null, null, false, false),
    /** 每日经验饮品使用次数增加固定值 */
    DAILY_EXP_DRUG_USE_NUMBER("dailyExpDrugUseNumber", AttributeType.DAILY_EXP_DRUG_USE_NUMBER, null, null, null, null, false, false),
    /** 训练默认经验加成百分比 */
    TRAINING_EXP_DEFAULT_PERCENT_UP("trainingExpDefaultPercentUp", AttributeType.TRAINING_EXP_DEFAULT_PERCENT_UP, null, null, null, null, false, false),
    /** 训练领悟效率加成百分比 */
    TRAINING_EXP_UNDERSTANDING_PERCENT_UP("trainingExpUnderstandingPercentUp", AttributeType.TRAINING_EXP_UNDERSTANDING_PERCENT_UP, null, null, null, null, false, false),


    ;

    /** 特殊属性集合set */
    private static final Set<AttributeTotalType> SPECIAL_ATTRS = new HashSet<>();

    /** typeStr : AttributeTotalTypeEnum */
    private static final Map<String, AttributeTotalType> ATTRIBUTE_TOTAL_TYPE_MAP = new HashMap<>();


    /** 宠物属性 */
    private static final Set<AttributeTotalType> GUARD_ATTRS = new HashSet<>();


    static {
        for (AttributeTotalType attributeType : values()) {
            ATTRIBUTE_TOTAL_TYPE_MAP.put(attributeType.type, attributeType);
            if (attributeType.isSpecialAttr()) {
                SPECIAL_ATTRS.add(attributeType);
            }
            if (attributeType.isGuardAttr()) {
                GUARD_ATTRS.add(attributeType);
            }
        }
    }

    /** 属性类型 */
    private final String type;
    /** 基础值属性 */
    private final AttributeType baseAttr;
    /** 增加累加百分比属性 */
    private final AttributeType percentAddUpAttr;
    /** 减少累加百分比属性 */
    private final AttributeType percentAddDownAttr;
    /** 增加累乘百分比属性 */
    private final AttributeType percentMultiplyAttr;
    /** 绝对值属性 */
    private final AttributeType absoluteAttr;
    /** 是否为特殊属性 */
    private final boolean specialAttr;
    /** 是否为宠物属性 */
    private final boolean guardAttr;


    AttributeTotalType(String type, AttributeType baseAttr, AttributeType percentAddUpAttr, AttributeType percentAddDownAttr, AttributeType percentMultiplyAttr, AttributeType absoluteAttr, boolean specialAttr, boolean guardAttr) {
        this.type = type;
        this.baseAttr = baseAttr;
        this.percentAddUpAttr = percentAddUpAttr;
        this.percentAddDownAttr = percentAddDownAttr;
        this.percentMultiplyAttr = percentMultiplyAttr;
        this.absoluteAttr = absoluteAttr;
        this.specialAttr = specialAttr;
        this.guardAttr = guardAttr;
    }

    /**
     * 获取特殊类型属性枚举Set
     */
    public static Set<AttributeTotalType> getSpecialAttrs() {
        return SPECIAL_ATTRS;
    }

    /**
     * 获取宠物类型属性集合
     */
    public static Set<AttributeTotalType> getGuardAttrs() {
        return GUARD_ATTRS;
    }

    public String getType() {
        return type;
    }

    public AttributeType getBaseAttr() {
        return baseAttr;
    }

    public AttributeType getPercentAddUpAttr() {
        return percentAddUpAttr;
    }

    public AttributeType getPercentAddDownAttr() {
        return percentAddDownAttr;
    }

    public AttributeType getPercentMultiplyAttr() {
        return percentMultiplyAttr;
    }

    public AttributeType getAbsoluteAttr() {
        return absoluteAttr;
    }

    public boolean isSpecialAttr() {
        return specialAttr;
    }

    public boolean isGuardAttr() {
        return guardAttr;
    }

    public static void main(String[] args) {
        for (AttributeTotalType type : values()) {
            System.out.print(type.getType() + "\t");
            String baseAttr = type.getBaseAttr() == null ? "\t" : type.getBaseAttr().getType() + "\t";
            System.out.print(baseAttr);
            String puAttr = type.getPercentAddUpAttr() == null ? "\t" : type.getPercentAddUpAttr().getType() + "\t";
            System.out.print(puAttr);
            String pdAttr = type.getPercentAddDownAttr() == null ? "\t" : type.getPercentAddDownAttr().getType() + "\t";
            System.out.print(pdAttr);
            String pmAttr = type.getPercentMultiplyAttr() == null ? "\t" : type.getPercentMultiplyAttr().getType() + "\t";
            System.out.print(pmAttr);
            String absAttr = type.getAbsoluteAttr() == null ? "\t" : type.getAbsoluteAttr().getType() + "\t";
            System.out.println(absAttr);
        }
    }
}
