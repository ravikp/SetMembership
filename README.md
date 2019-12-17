#README

The source code evaluates the performance of set membership using java set membership and bloom filters.

## Papers on Bloom filter
* https://en.wikipedia.org/wiki/Bloom_filter
* http://gsd.di.uminho.pt/members/cbm/ps/dbloom.pdf
* https://llimllib.github.io/bloomfilter-tutorial/
* [caching](http://pages.cs.wisc.edu/~cao/papers/summary-cache/node8.html)

## Memory calculation:
* https://hur.st/bloomfilter/
* https://toolslick.com/programming/data-structure/bloom-filter-calculator
* https://krisives.github.io/bloom-calculator/

## Alternatives:

### Cuckoo filter:
* https://www.cs.cmu.edu/~dga/papers/cuckoo-conext2014.pdf
* https://www.cs.cmu.edu/~binfan/papers/login_cuckoofilter.pdf
* https://en.wikipedia.org/wiki/Cuckoo_filter
* https://smartech.gatech.edu/handle/1853/60577

#### Fast Hash functions:
* https://github.com/google/cityhash
* http://isthe.com/chongo/tech/comp/fnv/
* https://tools.ietf.org/html/draft-eastlake-fnv-17

#### Usage

For anything beyond 50Million, 'java.util.Set' is going out of memory

`java -jar -Xms512m -Xmx5g ./build/libs/pds-0.1.0.jar 20000000 classic`

or

`java -jar -Xms512m -Xmx5g ./build/libs/pds-0.1.0.jar 20000000 fast`
