package cc.carm.lib.configuration.spigot;

import cc.carm.lib.configuration.core.source.ConfigurationWrapper;
import org.bukkit.configuration.ConfigurationSection;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SpigotSectionWrapper implements ConfigurationWrapper {

    private final ConfigurationSection section;

    private SpigotSectionWrapper(ConfigurationSection section) {
        this.section = section;
    }

    @Contract("!null->!null")
    public static @Nullable SpigotSectionWrapper of(@Nullable ConfigurationSection section) {
        return section == null ? null : new SpigotSectionWrapper(section);
    }

    @Override
    public @NotNull Set<String> getKeys(boolean deep) {
        return new LinkedHashSet<>(section.getKeys(deep));
    }

    @Override
    public @NotNull Map<String, Object> getValues(boolean deep) {
        return section.getValues(deep);
    }

    @Override
    public void set(@NotNull String path, @Nullable Object value) {
        this.section.set(path, value);
    }

    @Override
    public boolean contains(@NotNull String path) {
        return this.section.contains(path);
    }

    @Override
    public @Nullable Object get(@NotNull String path) {
        return this.section.get(path);
    }

    @Override
    public boolean isList(@NotNull String path) {
        return this.section.isList(path);
    }

    @Override
    public @Nullable List<?> getList(@NotNull String path) {
        return this.section.getList(path);
    }

    @Override
    public boolean isConfigurationSection(@NotNull String path) {
        return this.section.isConfigurationSection(path);
    }

    @Override
    public @Nullable ConfigurationWrapper getConfigurationSection(@NotNull String path) {
        return of(this.section.getConfigurationSection(path));
    }
}
