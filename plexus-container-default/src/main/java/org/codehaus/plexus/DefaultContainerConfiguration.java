package org.codehaus.plexus;

import org.codehaus.plexus.classworlds.ClassWorld;
import org.codehaus.plexus.classworlds.realm.ClassRealm;
import org.codehaus.plexus.container.initialization.ComponentDiscoveryPhase;
import org.codehaus.plexus.container.initialization.ContainerInitializationPhase;
import org.codehaus.plexus.container.initialization.InitializeComponentComposerPhase;
import org.codehaus.plexus.container.initialization.InitializeComponentDiscovererManagerPhase;
import org.codehaus.plexus.container.initialization.InitializeComponentFactoryManagerPhase;
import org.codehaus.plexus.container.initialization.InitializeComponentLookupManagerPhase;
import org.codehaus.plexus.container.initialization.InitializeComponentManagerManagerPhase;
import org.codehaus.plexus.container.initialization.InitializeComponentRepositoryPhase;
import org.codehaus.plexus.container.initialization.InitializeContextPhase;
import org.codehaus.plexus.container.initialization.InitializeLifecycleHandlerManagerPhase;
import org.codehaus.plexus.container.initialization.InitializeLoggerManagerPhase;
import org.codehaus.plexus.container.initialization.InitializeResourcesPhase;
import org.codehaus.plexus.container.initialization.InitializeSystemPropertiesPhase;
import org.codehaus.plexus.container.initialization.RegisterComponentDiscoveryListenersPhase;
import org.codehaus.plexus.container.initialization.StartLoadOnStartComponentsPhase;

import java.net.URL;
import java.util.Map;

/** @author Jason van Zyl */
public class DefaultContainerConfiguration
    implements ContainerConfiguration
{
    private String name;

    private Map context;

    private ClassWorld classWorld;

    private ClassRealm realm;

    private PlexusContainer parentContainer;

    private String containerConfiguration;

    private URL containerConfigurationURL;

    public ContainerConfiguration setName( String name )
    {
        this.name = name;

        return this;
    }

    public ContainerConfiguration setContext( Map context )
    {
        this.context = context;

        return this;
    }

    public ContainerConfiguration setClassWorld( ClassWorld classWorld )
    {
        this.classWorld = classWorld;

        return this;
    }

    public ContainerConfiguration setRealm( ClassRealm realm )
    {
        this.realm = realm;

        return this;
    }

    public ContainerConfiguration setParentContainer( PlexusContainer parentContainer )
    {
        this.parentContainer = parentContainer;

        return this;
    }

    public ContainerConfiguration setContainerConfiguration( String containerConfiguration )
    {
        this.containerConfiguration = containerConfiguration;

        return this;
    }

    public String getContainerConfiguration()
    {
        return containerConfiguration;
    }

    public ContainerConfiguration setContainerConfigurationURL( URL containerConfiguration )
    {
        this.containerConfigurationURL = containerConfiguration;

        return this;
    }

    public URL getContainerConfigurationURL()
    {
        return containerConfigurationURL;
    }

    public String getName()
    {
        return name;
    }

    public Map getContext()
    {
        return context;
    }

    public ClassWorld getClassWorld()
    {
        return classWorld;
    }

    public PlexusContainer getParentContainer()
    {
        return parentContainer;
    }

    public ClassRealm getRealm()
    {
        return realm;
    }

    // Programmatic Container Initialization and Setup

    public ContainerConfiguration setInitializationPhases( ContainerInitializationPhase[] initializationPhases )
    {
        this.initializationPhases = initializationPhases;

        return this;
    }

    public ContainerInitializationPhase[] getInitializationPhases()
    {
        return initializationPhases;
    }

    private ContainerInitializationPhase[] initializationPhases =
        {
            new InitializeResourcesPhase(),
            new InitializeComponentRepositoryPhase(),
            new InitializeLifecycleHandlerManagerPhase(),
            new InitializeComponentManagerManagerPhase(),
            new InitializeComponentDiscovererManagerPhase(),
            new InitializeComponentFactoryManagerPhase(),
            new InitializeComponentLookupManagerPhase(),
            new InitializeComponentComposerPhase(),
            new InitializeLoggerManagerPhase(),
            new InitializeContextPhase(),
            new InitializeSystemPropertiesPhase(),
            new RegisterComponentDiscoveryListenersPhase(),
            new ComponentDiscoveryPhase(),
            new StartLoadOnStartComponentsPhase(),

        };

    public ComponentLookupManager getComponentLookupManager()
    {
        return new DefaultComponentLookupManager();
    }
}