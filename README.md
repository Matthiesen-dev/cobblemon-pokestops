# Cobblemon Pokestops

This mod adds Pokémon GO inspired Pokestops to Cobblemon. Currently, Pokestops require someone with admin/creative permissions 
to place them, but in the future, we may add a way for players to place (or find?) them as well. 

Pokestops can be used to get items, and they have a cooldown period after being used.

## Available Pokestop Types

### Pokestop

The standard Pokestop design, which can be found in various colors.

- **Cooldown:** 5 minutes
- **Rewards:** 1-2 random items (e.g., Pokeballs, Potions, Revives)
- **Color Variants:**
  - Blue
  - Gold
  - Black

## Usage

Pokestops can be placed by players with admin or creative permissions by getting the desired Pokestop item and placing it 
in the world. Once placed, players can interact with the Pokestop to receive rewards, but they will need to wait for the 
cooldown period to expire before they can use it again.

## Configuration

The cooldown time and rewards can be configured in the mod's configuration file. This allows server owners to customize the
Pokestop experience to fit their server's needs. The configuration file can be found in the server's config directory after installing the mod.

- **Default config location:** `<server_dir>/config/cobblemon_pokestops/config.json`

### Default Configuration Example

```json
{
  "enableGlobalBroadcast": false,
  "localBroadcastRadius": 50.0,
  "pokestopCooldownSeconds": 300,
  "extraRarities": [
    "cobblemon:master_ball",
    "cobblemon:ability_capsule",
    "cobblemon:max_revive",
    "cobblemon:hyper_potion",
    "cobblemon:ultra_ball"
  ]
}
```

### Configuration Options

- `enableGlobalBroadcast`: If true, all players will receive a message when a Pokestop is used. If false, only players within the local broadcast radius will receive the message.
- `localBroadcastRadius`: The radius (in blocks) within which players will receive a message when a Pokestop is used if global broadcast is disabled.
- `pokestopCooldownSeconds`: The cooldown time (in seconds) for Pokestops after being used.
- `extraRarities`: A list of additional items list that defines items as "Rare" for the purpose of the Pokestop rewards. These items are used for determining the rarity of rewards given by Pokestops for usage in the rarity broadcast message.

### LootTable Configuration

The rewards given by Pokestops are determined by a loot table. The default loot table can be found in the mod's [resources directory](https://github.com/Matthiesen-dev/cobblemon-pokestops/tree/main/common/src/main/resources/data/cobblemon_pokestops/loot_table/gameplay), and server owners can create their own custom loot tables to further customize the rewards.

**Datapack Loot Table Locations:**
- **PokeStop:** `/data/cobblemon_pokestops/loot_table/gameplay/pokestop_loot.json`

## Future Plans

- Adding more Pokestop types with different rewards and cooldowns.
- Implementing a way for players to find the different Pokestop types in the world.