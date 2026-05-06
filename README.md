# More Attributes

A lightweight Forge 1.12.2 mod that adds **six RPG‑style attributes** and **six matching potion effects**, inspired by *Toram Online*. Assign attributes to any item via vanilla `AttributeModifiers` NBT, or brew potions to gain temporary boosts. **Zero base edits** – everything runs through standard Forge events without touching vanilla mechanics.

> AI‑assisted development.

---

## Attributes

| Attribute              | ID                                      | Effect                                                |
| ---------------------- | --------------------------------------- | ----------------------------------------------------- |
| Range Damage           | `moreattributes.rangeDamage`           | Multiplies projectile damage you deal                 |
| Magic Damage           | `moreattributes.magicDamage`           | Multiplies magic damage you deal                      |
| Short Range Damage     | `moreattributes.closeRangeDamage`      | Multiplies all damage you deal within 7 blocks        |
| Long Range Damage      | `moreattributes.longRangeDamage`       | Multiplies all damage you deal beyond 7 blocks        |
| Physical Resistance    | `moreattributes.physicalResistance`    | Multiplies non‑magic damage you take (diminishing)    |
| Magic Resistance       | `moreattributes.magicResistance`       | Multiplies magic damage you take (diminishing)        |

- Default `1.0` means no effect; range is `‑1024 … 1024`.
- Bonuses scale linearly; resistances use a diminishing/accelerating curve.
- All multipliers are independent → clean, predictable stacking.

---

## Potion Effects

Each effect boosts one attribute by **+1% per level**. All effects can be toggled individually in the mod’s config file.

| Potion            | Effect                                  | Boosts                         |
| ----------------- | --------------------------------------- | ------------------------------ |
| Bravery           | `moreattributes:bravery`               | Short Range Damage             |
| Snipe             | `moreattributes:snipe`                 | Long Range Damage              |
| Physical Defence  | `moreattributes:physicaldefence`       | Physical Resistance            |
| Magic Defence     | `moreattributes:magicdefence`          | Magic Resistance               |
| Deadeye           | `moreattributes:deadeye`               | Range Damage                   |
| Arcane            | `moreattributes:arcane`                | Magic Damage                   |

Potions can be obtained through brewing, commands, or the creative inventory just like vanilla effects.

---

## Usage

Add attribute modifiers via NBT on any item. Example – a bow with +15% ranged damage:

```json
{
  "AttributeModifiers": [
    {
      "AttributeName": "moreattributes.rangeDamage",
      "Name": "moreattributes.rangeDamage",
      "Amount": 0.15,
      "Operation": 1,
      "UUIDMost": 1001,
      "UUIDLeast": 2001,
      "Slot": "mainhand"
    }
  ]
}
```

One‑line `/give` command:

```
/give @p minecraft:bow 1 0 {AttributeModifiers:[{AttributeName:"moreattributes.rangeDamage",Name:"moreattributes.rangeDamage",Amount:0.15,Operation:1,UUIDMost:1001,UUIDLeast:2001,Slot:"mainhand"}]}
```

To apply a potion effect, use the vanilla `/effect` command, e.g.:

```
/effect give @p moreattributes:bravery 30 1
```
```
/give @p minecraft:potion 1 0 {CustomPotionEffects:[{Id:"moreattributes:bravery",Duration:200,Amplifier:1}]}
```
---

## Design

- **No base edits** – purely event‑driven (`LivingHurtEvent`); never alters projectile behaviour, damage types, or other vanilla systems.
- **Zero overhead at defaults** – attributes at `1.0` cost absolutely nothing.
- **Clean compatibility** – works seamlessly with other mods; all multipliers are commutative.
- **Configurable potions** – every potion effect can be disabled in `config/moreattributes.cfg` if not desired.

---

*Inspired by Toram Online. Built with AI assistance for minimal intrusion and maximum stability.*
