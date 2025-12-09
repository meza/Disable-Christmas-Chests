# Disable Christmas Chests

Client-side Fabric and NeoForge mod that prevents Mojang's Christmas chest textures from replacing the normal and trapped chest textures (Dec 24–26). Safe to leave installed all year; outside the holiday window nothing changes.

## What it does
- Keeps all chest variants to their regular texture during the seasonal event.
- Client-only; servers do not need the mod.
- Default keybind `G` lets you flip the festive textures on/off at runtime.

## Configuration (new)
A config file is created on first launch at `config/disable_christmas_chests.properties`.

- `christmasEnabled=true`: master switch; set to `false` to permanently suppress all festive textures regardless of date or keybind.
- `christmasMode=DISABLE` (default): `G` disables the Christmas textures while the event is active (Dec 24–26). Outside that window there are no seasonal textures to suppress.
- `christmasMode=TOGGLE`: `G` becomes a year-round toggle so you can enable the Christmas look whenever you want—handy for content creators or if you like the festive vibe in July.
- `showRegularChestPresents=true`: controls whether normal chests ever swap to presents when Christmas textures are currently enabled.
- `showTrappedChestPresents=true`: lets you hide the seasonal textures specifically for trapped chests while keeping other chests festive.
- `showCopperChestPresents=true`: same idea for copper chests (including its variants) so you can enable or disable their seasonal models independently; only present on Minecraft 1.21.9+ (The Copper Age update) where copper chests exist.

You can rebind the hotkey in the controls menu if `G` conflicts with your setup.

## Missing a version?
Open an issue with the Minecraft version you need: [issue tracker](https://github.com/meza/Disable-Christmas-Chests/issues).

## Why a mod?
When Minecraft applies the Christmas textures, trapped chests look identical to normal chests. This mod keeps the original textures so you can still tell them apart (and so resource packs that remove the Christmas textures remain meaningful).

For contributing, please see [CONTRIBUTING.md](CONTRIBUTING.md).
