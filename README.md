# More Attributes

A lightweight Forge 1.12.2 mod that adds **six RPG‑style attributes**, inspired by *Toram Online*. Assign them to any item using vanilla `AttributeModifiers` NBT. **Zero base edits** – purely event‑driven with no invasive changes to Minecraft.

> Developed with AI‑assisted code generation.

---

## Attributes

| Attribute | ID | Effect |
|-----------|----|--------|
| Range Damage | `moreattributes.rangeDamage` | Multiplies projectile damage you deal |
| Magic Damage | `moreattributes.magicDamage` | Multiplies magic damage you deal |
| Short Range Damage | `moreattributes.closeRangeDamage` | Multiplies all damage you deal within 7 blocks |
| Long Range Damage | `moreattributes.longRangeDamage` | Multiplies all damage you deal beyond 7 blocks |
| Physical Resistance | `moreattributes.physicalResistance` | Multiplies non‑magic damage you take (diminishing) |
| Magic Resistance | `moreattributes.magicResistance` | Multiplies magic damage you take (diminishing) |

- Default: `1.0` (no effect) – range: `-1024 .. 1024`
- Bonuses are linear, resistances use diminishing returns
- All multipliers are independent → stable stacking

---

## Usage

Add modifiers via NBT. Example:

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

Or one‑line command:
```
/give @p minecraft:bow 1 0 {AttributeModifiers:[{AttributeName:"moreattributes.rangeDamage",Name:"moreattributes.rangeDamage",Amount:0.15,Operation:1,UUIDMost:1001,UUIDLeast:2001,Slot:"mainhand"}]}
```

---

## Design

- **No base edits** – everything runs on standard Forge events (`LivingHurtEvent`).
- **Zero overhead at default values** – attributes left at `1.0` trigger no extra code.
- **Clean compatibility** – fully compatible with other mods; all stacking is predictable.

---

*Inspired by Toram Online. Built with AI assistance for minimal intrusion and maximum stability.*