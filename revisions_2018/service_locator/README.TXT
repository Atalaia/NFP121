
#verbose=true


# martin_fowler
bean.id.1=martin_fowler
martin_fowler.class=container.FileSystemPropsApplicationContext
martin_fowler.property.1=fileName
martin_fowler.property.1.param.1=./martin_fowler/README.TXT
martin_fowler.property.2=name
martin_fowler.property.2.param.1=MARTIN_FOWLER

# exemples
bean.id.2=exemples
exemples.class=container.FileSystemPropsApplicationContext
exemples.property.1=fileName
exemples.property.1.param.1=./exemples/README.TXT
exemples.property.2=name
exemples.property.2.param.1=EXEMPLES

# patron_commande
bean.id.3=patron_commande
patron_commande.class=container.FileSystemPropsApplicationContext
patron_commande.property.1=fileName
patron_commande.property.1.param.1=./command/README.TXT
patron_commande.property.2=name
patron_commande.property.2.param.1=PATRON_COMMANDE

# patron_observer
bean.id.4=patron_observer
patron_observer.class=container.FileSystemPropsApplicationContext
patron_observer.property.1=fileName
patron_observer.property.1.param.1=./observer/README.TXT
patron_observer.property.2=name
patron_observer.property.2.param.1=PATRON_OBSERVER

# patron_facade
bean.id.5=patron_facade
patron_facade.class=container.FileSystemPropsApplicationContext
patron_facade.property.1=fileName
patron_facade.property.1.param.1=./facade/README.TXT
patron_facade.property.2=name
patron_facade.property.2.param.1=PATRON_FACADE

# patron_proxy
bean.id.6=patron_proxy
patron_proxy.class=container.FileSystemPropsApplicationContext
patron_proxy.property.1=fileName
patron_proxy.property.1.param.1=./proxy/README.TXT
patron_proxy.property.2=name
patron_proxy.property.2.param.1=PATRON_PROXY

# patron_state
bean.id.7=patron_state
patron_state.class=container.FileSystemPropsApplicationContext
patron_state.property.1=fileName
patron_state.property.1.param.1=./state/README.TXT
patron_state.property.2=name
patron_state.property.2.param.1=PATRON_STATE


# doit être le dernier des beans à être initialisé
# en interne setContainer utilise le nom de chaque conteneur
# nom intialisé par femtoContainer
bean.id.8=serviceLocator
serviceLocator.class=service_locator.ServiceLocator
serviceLocator.property.1=container
serviceLocator.property.1.param.1=martin_fowler
serviceLocator.property.2=container
serviceLocator.property.2.param.1=exemples
serviceLocator.property.3=container
serviceLocator.property.3.param.1=patron_commande
serviceLocator.property.4=container
serviceLocator.property.4.param.1=patron_observer
serviceLocator.property.5=container
serviceLocator.property.5.param.1=patron_facade
serviceLocator.property.6=container
serviceLocator.property.6.param.1=patron_proxy
serviceLocator.property.7=container
serviceLocator.property.7.param.1=patron_state

