#include <bitset>   // compact STL for Sieve, more efficient than vector<bool>!
#include <cmath>
#include <cstdio>
#include <map>
#include <vector>
#include <iostream>

using namespace std;

typedef long long ll;
typedef vector<int> vi;
typedef map<int, int> mii;

ll _sieve_size;
bitset<10000010> bs;   // 10^7 should be enough for most cases
vi primes;   // compact list of primes in form of vector<int>


// first part

void sieve(ll upperbound) {          // create list of primes in [0..upperbound]
  _sieve_size = upperbound + 1;                   // add 1 to include upperbound
  bs.set();                                                 // set all bits to 1
  bs[0] = bs[1] = 0;                                     // except index 0 and 1
  for (ll i = 2; i <= _sieve_size; i++) if (bs[i]) {
    // cross out multiples of i starting from i * i!
    for (ll j = i * i; j <= _sieve_size; j += i) bs[j] = 0;
    primes.push_back((int)i);  // also add this vector containing list of primes
} }                                           // call this method in main method

bool isPrime(ll N) {                 // a good enough deterministic prime tester
  if (N <= _sieve_size) return bs[N];                   // O(1) for small primes
  for (int i = 0; i < (int)primes.size(); i++)
    if (N % primes[i] == 0) return false;
  return true;                    // it takes longer time if N is a large prime!
}                      // note: only work for N <= (last prime in vi "primes")^2

ll numDiv(ll N,ll q) {
  ll PF_idx = 0, PF = primes[PF_idx], ans = 1;             // start from ans = 1
  while (N != 1 && (PF * PF <= N)) {
    ll power = 0;                                             // count the power
    while (N % PF == 0) { N /= PF; power++; }
    if(PF%q!=0){
    ans *= (power + 1);
    }                  // according to the formula
    PF = primes[++PF_idx];
  }
  if (N != 1 &&N!=q) ans *= 2;             // (last factor has pow = 1, we add 1 to it)
  return ans;
}


int main() {
  // first part: the Sieve of Eratosthenes
  sieve(10000000);                       // can go up to 10^7 (need few seconds)

  ll t,a,b,r,acc;

  while( (scanf("%lld %lld %lld",&t,&a,&b ))!=EOF  ){
    while(t-->0){
        cin >>r;
        acc=0;
        ll i=a;
        while(i<=b){
            if(i==r){
            acc++;
            }
            else{
            acc+=numDiv(i,r);
            }
            i++;

        }
        cout << acc<<endl;
    }
  }



  return 0;
}
