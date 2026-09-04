# Cobblemon Pokestops

<div>
  <img src="https://mods.matthiesen.dev/badges/matthiesenCore.svg" alt="Matthiesen Core">
  <img src="https://mods.matthiesen.dev/badges/cobblemon.svg" alt="Cobblemon">
  <img src="https://mods.matthiesen.dev/badges/geckolib.svg" alt="GeckoLib">
</div>

This mod adds Pokemon GO inspired Pokestops to Cobblemon. Pokestops can be used to get items, and they have a cooldown period after being used.

### World Generation

Find Pokestops scattered throughout the world! Pokestops can be found throughout the overworld in various biomes! Keep an eye out for them while exploring, as they can be a great source of items and rewards.

### Trophies

In addition to the standard Pokestop blocks, there are also Trophies that can be obtained by using Pokestops. These trophies are purely
cosmetic and serve as a way to show off your dedication to the Pokestop system. They can be displayed in item frames or used as decorative items in your builds.

Finish the Advancement Chain in-game to obtain the Trophies, which include:
- **Pokestop Trophy:** Awarded for using a Pokestop 500 times.
- **Wingedstop Trophy:** Awarded for using a Winged Pokestop 500 times.
- **Pokeball Stop Trophy:** Awarded for using a Pokeball Stop 500 times.
- **Healing Stop Trophy:** Awarded for using a Healing Stop 500 times.

## Dependencies

- [Matthiesen Core](https://modrinth.com/mod/matthiesen-core)
- [Cobblemon](https://modrinth.com/mod/cobblemon)
- [Geckolib](https://modrinth.com/mod/geckolib)
- [Fabric API](https://modrinth.com/mod/fabric-api) (Fabric only)
- [Forge Config API Port](https://modrinth.com/mod/forge-config-api-port) (Fabric only)

## Optional Dependencies
- [Jade 15.10.5+](https://modrinth.com/mod/jade) (For in-game Pokestop information display)

## Available Pokestop Types

### Pokestop

The standard Pokestop design, which can be found in various colors.

- **Cooldown:** 5 minutes
- **Rewards:** 1-2 random items from the Pokestop loot table
- **Color Variants:**
    - Blue
    - Gold
    - Green
    - Black

### Wingedstop

A Pokestop variant with wings, giving it a more unique appearance.

- **Cooldown:** 5 minutes
- **Rewards:** 1-2 random items from the Wingedstop loot table
- **Color Variants:**
    - Blue
    - Gold
    - Green

### Pokeball Stop

A Pokestop variant designed to look like a giant Pokeball.

- **Cooldown:** 5 minutes
- **Rewards:** 1-2 random items from the Pokeball Stop loot table
- **Variants:**
    - Park Ball
    - Premier Ball
    - Ultra Ball
    - Master Ball

### Healing Stop

A Pokestop variant designed to look like a healing station, providing players with healing items.

- **Cooldown:** 10 minutes
- **Rewards:** Heals the player's Pokemon when used
- **Variants:** N/A (Currently only one design, but more may be added in the future)

## Docs

Documentation for this mod can be found at [mods.matthiesen.dev](https://mods.matthiesen.dev/cobblemon-pokestops/)

## Version Compatibility

| Minecraft Version | Matthiesen Core Version | Cobblemon Version | Mod Version |
|-------------------|-------------------------|-------------------|-------------|
| 1.21.1            | 1.2.7+                  | 1.7.3             | 1.4.x+      |

## FastStats Metrics

This mod uses [FastStats](https://faststats.dev) to collect anonymous usage statistics. This helps the developer understand
how this mod is being used and improve it over time. You can learn more about the data collected and how it is used by visiting
[FastStats: Information](https://faststats.dev/info).

You can also view the data collected by this mod on the [FastStats: Cobblemon Pokestops](https://faststats.dev/project/cobblemon-pokestops) page.

To opt out of this data collection, set the `enabled` property to `false` in the `<game_directory>/config/matthiesen_core/metrics.properties` file.

## License

MIT - see `LICENSE`.