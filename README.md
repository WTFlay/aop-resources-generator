# AOP Resources Generator

## How to use it

1. Create a YML file containing the description of your data models:
```yaml
---
module-contact.yml
---
models:
  - title:
      name: string
      code: string
  - country:
      name: string
      code: string
  - address:
      street: string
      zip: string
      city: string
      country:
        type: m2o
        ref: country
  - contact:
      title:
        type: m2o
        ref: title
      lastName: string
      firstName: string
      fullName: string
      birthDate: date
      email: string
      phone: string
      address:
        type: m2o
        ref: address
      image: binary
```
2. Launch the client with the file as argument and the destination folder:
```bash
$ java -jar resgen.jar contact.yml -d contact-resources/
```

3. You domains, views and menus in XML are generated. You can copy and
modify them in your AOP application to save precious time.