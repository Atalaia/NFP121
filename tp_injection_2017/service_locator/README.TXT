
#verbose=true

bean.id.1=serviceLocator
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



# martin_fowler
bean.id.2=martin_fowler
martin_fowler.class=container.FileSystemPropsApplicationContext
martin_fowler.property.1=fileName
martin_fowler.property.1.param.1=./martin_fowler/README.TXT

# exemples
bean.id.3=exemples
exemples.class=container.FileSystemPropsApplicationContext
exemples.property.1=fileName
exemples.property.1.param.1=./exemples/README.TXT

# patron_commande
bean.id.4=patron_commande
patron_commande.class=container.FileSystemPropsApplicationContext
patron_commande.property.1=fileName
patron_commande.property.1.param.1=./command/README.TXT

# patron_observer
bean.id.5=patron_observer
patron_observer.class=container.FileSystemPropsApplicationContext
patron_observer.property.1=fileName
patron_observer.property.1.param.1=./observer/README.TXT

# patron_facade
bean.id.6=patron_facade
patron_facade.class=container.FileSystemPropsApplicationContext
patron_facade.property.1=fileName
patron_facade.property.1.param.1=./facade/README.TXT

# patron_proxy
bean.id.7=patron_proxy
patron_proxy.class=container.FileSystemPropsApplicationContext
patron_proxy.property.1=fileName
patron_proxy.property.1.param.1=./proxy/README.TXT

