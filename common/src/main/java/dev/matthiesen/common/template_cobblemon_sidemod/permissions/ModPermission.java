package dev.matthiesen.common.template_cobblemon_sidemod.permissions;

import com.cobblemon.mod.common.api.permission.Permission;
import com.cobblemon.mod.common.api.permission.PermissionLevel;
import dev.matthiesen.common.template_cobblemon_sidemod.Constants;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class ModPermission implements Permission {
    private final String node;
    private final PermissionLevel level;
    private final ResourceLocation identifier;
    private final String literal;

    public ModPermission(String node, PermissionLevel level) {
        this.node = node;
        this.level = level;
        this.identifier = ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, this.node);
        this.literal = Constants.MOD_ID + "." + this.node;
    }

    @Override
    public @NotNull ResourceLocation getIdentifier() {
        return identifier;
    }

    @Override
    public @NotNull String getLiteral() {
        return literal;
    }

    @Override
    public @NotNull PermissionLevel getLevel() {
        return level;
    }

    // Optional: equals, hashCode, and toString methods for data class behavior
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModPermission that = (ModPermission) o;
        return java.util.Objects.equals(node, that.node) &&
                java.util.Objects.equals(level, that.level);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(node, level);
    }

    @Override
    public String toString() {
        return "CobblemonPokeTotem{" +
                "node='" + node + '\'' +
                ", level=" + level +
                ", identifier=" + identifier +
                ", literal='" + literal + '\'' +
                '}';
    }
}